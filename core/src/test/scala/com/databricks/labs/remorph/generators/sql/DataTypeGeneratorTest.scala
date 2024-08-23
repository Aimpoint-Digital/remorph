package com.databricks.labs.remorph.generators.sql

import com.databricks.labs.remorph.generators.GeneratorContext
import com.databricks.labs.remorph.parsers.{intermediate => ir}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class DataTypeGeneratorTest extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {

  val translations = Table(
    ("datatype", "expected translation"),
    (ir.NullType, "VOID"),
    (ir.BooleanType, "BOOLEAN"),
    (ir.BinaryType, "BINARY"),
    (ir.ShortType, "SMALLINT"),
    (ir.IntegerType, "INT"),
    (ir.LongType, "BIGINT"),
    (ir.FloatType, "FLOAT"),
    (ir.DoubleType, "DOUBLE"),
    (ir.StringType, "STRING"),
    (ir.DateType, "DATE"),
    (ir.TimestampType, "TIMESTAMP"),
    (ir.TimestampNTZType, "TIMESTAMP_NTZ"),
    (ir.DecimalType(None, None), "DECIMAL"),
    (ir.DecimalType(Some(10), None), "DECIMAL(10)"),
    (ir.DecimalType(Some(38), Some(6)), "DECIMAL(38, 6)"),
    (ir.ArrayType(ir.StringType), "ARRAY<STRING>"),
    (ir.ArrayType(ir.ArrayType(ir.IntegerType)), "ARRAY<ARRAY<INT>>"),
    (ir.MapType(ir.StringType, ir.DoubleType), "MAP<STRING, DOUBLE>"),
    (ir.MapType(ir.StringType, ir.ArrayType(ir.DateType)), "MAP<STRING, ARRAY<DATE>>"),
    (
      ir.StructExpr(
        Seq(
          ir.Alias(ir.Literal(1), ir.Id("a")),
          ir.Alias(ir.Literal("two"), ir.Id("b")),
          ir.Alias(ir.Literal(Seq(1, 2, 3)), ir.Id("c"))))
        .dataType,
      "STRUCT<a:INT,b:STRING,c:ARRAY<INT>>"))

  "DataTypeGenerator" should {
    "generate proper SQL data types" in {
      forAll(translations) { (dt, expected) =>
        val logical = new LogicalPlanGenerator(new ExpressionGenerator())
        DataTypeGenerator.generateDataType(GeneratorContext(logical), dt) shouldBe expected
      }
    }
  }
}
