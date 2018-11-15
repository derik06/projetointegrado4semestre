--LIGA LED

INSERT INTO 
	`tb_fato_led`(`ID_FATO_LED`, `DT_INICIO`, `DT_FIM`, `INTERVALO_TEMPO`, `ID_LED`, `CONSUMO`, `VALOR`) 
VALUES 
 	(NULL, NOW(), NULL, NULL, /*Id do LED que foi ligado*/, NULL, NULL)

--BUSCA ID_FATO_LED

SELECT
    MAX(ID_FATO_LED)
FROM
    TB_FATO_LED
WHERE
    ID_LED = --Id do LED que foi apagado

--APAGA LED

UPDATE 
	`tb_fato_led`
SET 
    `DT_FIM`= NOW(),
    `INTERVALO_TEMPO` = NOW() - DT_INICIO,
    `CONSUMO` = (NOW() - DT_INICIO) * (
            SELECT 
                POTENCIA 
            FROM 
                tb_led 
            WHERE 
                ID_LED = /*Id do LED que foi apagado*/
        ),
    `VALOR` = ((NOW() - DT_INICIO) * (
            SELECT 
                POTENCIA 
            FROM 
                tb_led 
            WHERE 
                ID_LED = /*Id do LED que foi apagado*/
        )) * /*Valor em R$ por energia 0,001*/
WHERE
	ID_FATO_LED = --BUSCA ID_FATO_LED

--RELATORIO GERAL

SELECT
	SUM(CONSUMO) AS CONSUMO,
    SUM(VALOR) AS VALOR,
    SUM(INTERVALO_TEMPO) AS INTERVALO_TEMPO
FROM 
	`tb_fato_led`
WHERE 
    --Exemplo Mês de Novembro
	DT_INICIO > /*Data inicial. Ex:*/ '2018-10-31 23.59.59'
    AND DT_FIM < /*Data Final. Ex:*/ '2018-12-01 00.00.00'

--RELATORIO DETALHADO

SELECT
	B.ID_LED,
    B.POTENCIA,
    SUM(A.CONSUMO) AS CONSUMO,
    SUM(A.VALOR) AS VALOR,
    SUM(A.INTERVALO_TEMPO) AS INTERVALO_TEMPO
FROM 
	tb_fato_led A
    	INNER JOIN tb_led B
        	ON A.ID_LED = B.ID_LED 
WHERE 
    --Exemplo Mês de Novembro
	A.DT_INICIO > /*Data inicial. Ex:*/ '2018-10-31 23.59.59'
    AND A.DT_FIM < /*Data Final. Ex:*/ '2018-12-01 00.00.00'
GROUP BY 
	ID_LED

--RELATORIO GERAL GROUP BY DIA

SELECT
	DT_INICIO,
	SUM(CONSUMO) AS CONSUMO,
    SUM(VALOR) AS VALOR,
    SUM(INTERVALO_TEMPO) AS INTERVALO_TEMPO
FROM 
	`tb_fato_led`
WHERE 
    --Exemplo Mês de Novembro
	DT_INICIO > /*Data inicial. Ex:*/ '2018-10-31 23.59.59'
    AND DT_FIM < /*Data Final. Ex:*/ '2018-12-01 00.00.00'
GROUP BY 
    year(DT_INICIO), 
    month(DT_INICIO), 
    day(DT_INICIO)