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