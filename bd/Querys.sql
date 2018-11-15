--LIGA LED

INSERT INTO 
	`tb_fato_led`(`ID_FATO_LED`, `DT_INICIO`, `DT_FIM`, `INTERVALO_TEMPO`, `ID_LED`, `CONSUMO`, `VALOR`) 
 VALUES 
 	(NULL, NOW(), NULL, NULL, 2, NULL, NULL)

--BUSCA ID_FATO_LED

SELECT
    MAX(ID_FATO_LED)
FROM
    TB_FATO_LED
WHERE
    ID_LED = --VEM DO ARDUINO

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
                ID_LED = --VEM DO ARDUINO
        ),
    `VALOR` = ((NOW() - DT_INICIO) * (
            SELECT 
                POTENCIA 
            FROM 
                tb_led 
            WHERE 
                ID_LED = 2
        )) * 0.5
WHERE
	ID_FATO_LED = BUSCA ID_FATO_LED