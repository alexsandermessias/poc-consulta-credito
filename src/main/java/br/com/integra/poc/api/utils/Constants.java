package br.com.integra.poc.api.utils;

public final class Constants {

	public static final String SEQUENCE_TITLE = "status_sequence";
	public static final String SEQUENCE_NAME = "sq_logs";
	public static final String LOG_TABLE_NAME = "credito";
	public static final String CREDITO_TABLE_NAME = "credito";
	public static final String LOG_COLUMN_ID = "id_evt";
	public static final String LOG_COLUMN_DATA_ENVIO = "dt_envio";
	public static final String LOG_COLUMN_DATA_INCLUSAO = "dt_inclusao";
	public static final String LOG_COLUMN_QTD_TENTATIVAS = "qt_tentativas";
	public static final String LOG_COLUMN_STC_RETORNO = "st_retorno";
	public static final String LOG_COLUMN_STC_ENVIO= "st_envio";
	public static final String LOG_COLUMN_BODY = "tx_body";
	public static final String ENDPOINT_GITHUB = "/api/v1/poc";
	public static final String PATH_GITHUB = "/{username}/{repository}";

	private Constants() {
		throw new IllegalStateException("Utility class");
	}

}
