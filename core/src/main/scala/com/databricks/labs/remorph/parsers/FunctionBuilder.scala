package com.databricks.labs.remorph.parsers

import com.databricks.labs.remorph.parsers.{intermediate => ir}

import java.util.Locale

sealed trait FunctionArity
case class FixedArity(arity: Int, convertible: Boolean = true) extends FunctionArity
case class VariableArity(argMin: Int, argMax: Int, convertible: Boolean = true) extends FunctionArity

class FunctionBuilder

object FunctionBuilder {

  // TODO: Add more functions as we find them
  // GCOVR_EXCL_START
  def functionArity(functionName: String): Option[FunctionArity] = functionName match {
    case "APP_NAME" => Some(FixedArity(0))
    case "APPLOCK_MODE" => Some(FixedArity(3))
    case "APPLOCK_TEST" => Some(FixedArity(4))
    case "ASSEMBLYPROPERTY" => Some(FixedArity(2))
    case "COL_LENGTH" => Some(FixedArity(2))
    case "COL_NAME" => Some(FixedArity(2))
    case "COLUMNPROPERTY" => Some(FixedArity(3))
    case "DATABASEPROPERTY" => Some(FixedArity(2))
    case "DATABASEPROPERTYEX" => Some(FixedArity(2))
    case "DB_ID" => Some(VariableArity(0, 1))
    case "DB_NAME" => Some(VariableArity(0, 1))
    case "FILE_ID" => Some(FixedArity(1))
    case "FILE_IDEX" => Some(FixedArity(1))
    case "FILE_NAME" => Some(FixedArity(1))
    case "FILEGROUP_ID" => Some(FixedArity(1))
    case "FILEGROUP_NAME" => Some(FixedArity(1))
    case "FILEGROUPPROPERTY" => Some(FixedArity(2))
    case "FILEPROPERTY" => Some(FixedArity(2))
    case "FILEPROPERTYEX" => Some(FixedArity(2))
    case "FULLTEXTCATALOGPROPERTY" => Some(FixedArity(2))
    case "FULLTEXTSERVICEPROPERTY" => Some(FixedArity(1))
    case "INDEX_COL" => Some(FixedArity(3))
    case "INDEXKEY_PROPERTY" => Some(FixedArity(3))
    case "INDEXPROPERTY" => Some(FixedArity(3))
    case "OBJECT_DEFINITION" => Some(FixedArity(1))
    case "OBJECT_ID" => Some(VariableArity(1, 2))
    case "OBJECT_NAME" => Some(VariableArity(1, 2))
    case "OBJECT_SCHEMA_NAME" => Some(VariableArity(1, 2))
    case "OBJECTPROPERTY" => Some(FixedArity(2))
    case "OBJECTPROPERTYEX" => Some(FixedArity(2))
    case "ORIGINAL_DB_NAME" => Some(FixedArity(0))
    case "PARSENAME" => Some(FixedArity(2))
    case "SCHEMA_ID" => Some(VariableArity(0, 1))
    case "SCHEMA_NAME" => Some(VariableArity(0, 1))
    case "SCOPE_IDENTITY" => Some(FixedArity(0))
    case "SERVERPROPERTY" => Some(FixedArity(1))
    case "STATS_DATE" => Some(FixedArity(2))
    case "TYPE_ID" => Some(FixedArity(1))
    case "TYPE_NAME" => Some(FixedArity(1))
    case "TYPEPROPERTY" => Some(FixedArity(2))
    case "ASCII" => Some(FixedArity(1))
    case "CHAR" => Some(FixedArity(1))
    case "CHARINDEX" => Some(VariableArity(2, 3))
    case "CONCAT" => Some(VariableArity(2, Int.MaxValue))
    case "CONCAT_WS" => Some(VariableArity(3, Int.MaxValue))
    case "DIFFERENCE" => Some(FixedArity(2))
    case "FORMAT" => Some(VariableArity(2, 3))
    case "LEFT" => Some(FixedArity(2))
    case "LEN" => Some(FixedArity(1))
    case "LOWER" => Some(FixedArity(1))
    case "LTRIM" => Some(FixedArity(1))
    case "NCHAR" => Some(FixedArity(1))
    case "PATINDEX" => Some(FixedArity(2))
    case "QUOTENAME" => Some(VariableArity(1, 2))
    case "REPLACE" => Some(FixedArity(3))
    case "REPLICATE" => Some(FixedArity(2))
    case "REVERSE" => Some(FixedArity(1))
    case "RIGHT" => Some(FixedArity(2))
    case "RTRIM" => Some(FixedArity(1))
    case "SOUNDEX" => Some(FixedArity(1))
    case "SPACE" => Some(FixedArity(1))
    case "STR" => Some(VariableArity(1, 3))
    case "STRING_AGG" => Some(VariableArity(2, 3))
    case "STRING_ESCAPE" => Some(FixedArity(2))
    case "STUFF" => Some(FixedArity(4))
    case "SUBSTRING" => Some(VariableArity(2, 3))
    case "TRANSLATE" => Some(FixedArity(3))
    case "TRIM" => Some(VariableArity(1, 2))
    case "UNICODE" => Some(FixedArity(1))
    case "UPPER" => Some(FixedArity(1))
    case "COMPRESS" => Some(FixedArity(1))
    case "CONNECTIONPROPERTY" => Some(FixedArity(1, convertible = false))
    case "CONTEXT_INFO" => Some(FixedArity(0))
    case "CURRENT_REQUEST_ID" => Some(FixedArity(0))
    case "CURRENT_TRANSACTION_ID" => Some(FixedArity(0))
    case "DECOMPRESS" => Some(FixedArity(1))
    case "ERROR_LINE" => Some(FixedArity(0))
    case "ERROR_MESSAGE" => Some(FixedArity(0))
    case "ERROR_NUMBER" => Some(FixedArity(0))
    case "ERROR_PROCEDURE" => Some(FixedArity(0))
    case "ERROR_SEVERITY" => Some(FixedArity(0))
    case "ERROR_STATE" => Some(FixedArity(0))
    case "FORMATMESSAGE" => Some(VariableArity(2, Int.MaxValue))
    case "GET_FILESTREAM_TRANSACTION_CONTEXT" => Some(FixedArity(0))
    case "GETANSINULL" => Some(VariableArity(0, 1))
    case "HOST_ID" => Some(FixedArity(0))
    case "HOST_NAME" => Some(FixedArity(0))
    case "ISNULL" => Some(FixedArity(2))
    case "ISNUMERIC" => Some(FixedArity(1))
    case "NEWID" => Some(FixedArity(0))
    case "NEWSEQUENTIALID" => Some(FixedArity(0))
    case "ROWCOUNT_BIG" => Some(FixedArity(0))
    case "SESSION_CONTEXT" => Some(VariableArity(1, 2))
    case "XACT_STATE" => Some(FixedArity(0))
    case "CONVERT" => Some(VariableArity(2, 3))
    case "COALESCE" => Some(VariableArity(1, Int.MaxValue))
    case "CURSOR_STATUS" => Some(FixedArity(2))
    case "CERT_ID" => Some(FixedArity(1))
    case "DATALENGTH" => Some(FixedArity(1))
    case "IDENT_CURRENT" => Some(FixedArity(1))
    case "IDENT_INCR" => Some(FixedArity(1))
    case "IDENT_SEED" => Some(FixedArity(1))
    case "SQL_VARIANT_PROPERTY" => Some(FixedArity(2))
    case "CURRENT_DATE" => Some(FixedArity(0))
    case "CURRENT_TIMESTAMP" => Some(FixedArity(0))
    case "CURRENT_TIMEZONE" => Some(FixedArity(0))
    case "CURRENT_TIMEZONE_ID" => Some(FixedArity(0))
    case "DATE_BUCKET" => Some(VariableArity(3, 4))
    case "DATEADD" => Some(FixedArity(3))
    case "DATEDIFF" => Some(FixedArity(3))
    case "DATE_DIFF_BIG" => Some(FixedArity(3))
    case "DATEFROMPARTS" => Some(FixedArity(3))
    case "DATENAME" => Some(FixedArity(2))
    case "DATEPART" => Some(FixedArity(2))
    case "DATETIME2FROMPARTS" => Some(FixedArity(8))
    case "DATETIMEFROMPARTS" => Some(FixedArity(7))
    case "DATETIMEOFFSETFROMPARTS" => Some(FixedArity(10))
    case "DATETRUNC" => Some(FixedArity(2))
    case "DAY" => Some(FixedArity(1))
    case "EOMONTH" => Some(VariableArity(1, 2))
    case "GETDATE" => Some(FixedArity(0))
    case "GETUTCDATE" => Some(FixedArity(0))
    case "ISDATE" => Some(FixedArity(1))
    case "MONTH" => Some(FixedArity(1))
    case "SMALLDATETIMEFROMPARTS" => Some(FixedArity(5))
    case "SWITCHOFFSET" => Some(FixedArity(2))
    case "SYSDATETIME" => Some(FixedArity(0))
    case "SYSDATETIMEOFFSET" => Some(FixedArity(0))
    case "SYSUTCDATETIME" => Some(FixedArity(0))
    case "TIMEFROMPARTS" => Some(FixedArity(5))
    case "TODATETIMEOFFSET" => Some(FixedArity(2))
    case "YEAR" => Some(FixedArity(1))
    case "MIN_ACTIVE_ROWVERSION" => Some(FixedArity(0))
    case "NULLIF" => Some(FixedArity(2))
    case "PARSE" => Some(VariableArity(2, 3))
    case "IFF" => Some(FixedArity(3))
    case "ISJSON" => Some(VariableArity(1, 2))
    case "JSON_VALUE" => Some(FixedArity(2))
    case "JSON_QUERY" => Some(FixedArity(2))
    case "JSON_MODIFY" => Some(FixedArity(3))
    case "JSON_PATH_EXISTS" => Some(FixedArity(2))
    case "ABS" => Some(FixedArity(1))
    case "ACOS" => Some(FixedArity(1))
    case "ASIN" => Some(FixedArity(1))
    case "ATAN" => Some(FixedArity(1))
    case "ATN2" => Some(FixedArity(2))
    case "CEILING" => Some(FixedArity(1))
    case "COS" => Some(FixedArity(1))
    case "COT" => Some(FixedArity(1))
    case "DEGREES" => Some(FixedArity(1))
    case "EXP" => Some(FixedArity(1))
    case "FLOOR" => Some(FixedArity(1))
    case "LOG" => Some(VariableArity(1, 2))
    case "LOG10" => Some(FixedArity(1))
    case "PI" => Some(FixedArity(0))
    case "POWER" => Some(FixedArity(2))
    case "RADIANS" => Some(FixedArity(1))
    case "RAND" => Some(VariableArity(0, 1))
    case "ROUND" => Some(VariableArity(2, 3))
    case "SIGN" => Some(FixedArity(1))
    case "SIN" => Some(FixedArity(1))
    case "SQRT" => Some(FixedArity(1))
    case "SQUARE" => Some(FixedArity(1))
    case "TAN" => Some(FixedArity(1))
    case "GREATEST" => Some(VariableArity(1, Int.MaxValue))
    case "LEAST" => Some(VariableArity(1, Int.MaxValue))
    case "CERTENCODED" => Some(FixedArity(1))
    case "CERTPRIVATEKEY" => Some(VariableArity(2, 3))
    case "CURRENT_USER" => Some(FixedArity(0))
    case "DATABASE_PRINCIPAL_ID" => Some(VariableArity(0, 1))
    case "HAS_DBACCESS" => Some(FixedArity(1))
    case "HAS_PERMS_BY_NAME" => Some(VariableArity(4, 5))
    case "IS_MEMBER" => Some(FixedArity(1))
    case "IS_ROLEMEMBER" => Some(VariableArity(1, 2))
    case "IS_SRVROLEMEMBER" => Some(VariableArity(1, 2))
    case "LOGINPROPERTY" => Some(FixedArity(2))
    case "ORIGINAL_LOGIN" => Some(FixedArity(0))
    case "PERMISSIONS" => Some(VariableArity(0, 2))
    case "PWDENCRYPT" => Some(FixedArity(1))
    case "PWDCOMPARE" => Some(VariableArity(2, 3))
    case "SESSIONPROPERTY" => Some(FixedArity(1))
    case "SUSER_ID" => Some(VariableArity(0, 1))
    case "SUSER_NAME" => Some(VariableArity(0, 1))
    case "SUSER_SID" => Some(VariableArity(0, 2))
    case "SUSER_SNAME" => Some(VariableArity(0, 1))
    case "USER_ID" => Some(VariableArity(0, 1))
    case "USER_NAME" => Some(VariableArity(0, 1))
    case _ => None
  }
  // GCOVR_EXCL_STOP

  def buildFunction(name: String, args: Seq[ir.Expression]): ir.Expression = {
    val uName = name.toUpperCase(Locale.getDefault())
    val defnOption = functionArity(uName)

    defnOption match {
      case Some(FixedArity(_, false)) | Some(VariableArity(_, _, false)) =>
        // Should raise a warning/lint error here
        ir.UnresolvedFunction(name, args, is_distinct = false, is_user_defined_function = false)

      case Some(FixedArity(arity, true)) if args.length == arity =>
        ir.CallFunction(name, args)

      case Some(VariableArity(argMin, argMax, true)) if args.length >= argMin && args.length <= argMax =>
        ir.CallFunction(name, args)

      case Some(_) =>
        // Should raise a warning/lint error here about mismatched argument count
        ir.UnresolvedFunction(name, args, is_distinct = false, is_user_defined_function = false)

      case None =>
        // Should raise a warning/lint error here about unknown function
        ir.UnresolvedFunction(name, args, is_distinct = false, is_user_defined_function = false)
    }
  }
}