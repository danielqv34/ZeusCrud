CREATE OR REPLACE PROCEDURE C##DQUIROZ.SP_INSERTA_PERSONAS (
   V_NOMBRE               IN PERSONAS.NOMBRE%TYPE,
   V_APELLIDO             IN PERSONAS.APELLIDO%TYPE,
   V_CEDULA               IN PERSONAS.CEDULA%TYPE,
   V_CORREELECTRONICO     IN PERSONAS.CORREELECTRONICO%TYPE,
   V_ESTADO               IN PERSONAS.ESTADO%TYPE,
   V_FECHANACIMIENTO      IN PERSONAS.FECHANACIMIENTO%TYPE,
   V_FECHAREGISTRO        IN PERSONAS.FECHAREGISTRO%TYPE,
   V_FECHAACTUALIZACION   IN PERSONAS.FECHAACTUALIZACION%TYPE)
IS
BEGIN
   IF (V_CORREELECTRONICO) IS NULL THEN
     IF V_CEDULA IS NULL THEN
      DBMS_OUTPUT.PUT_LINE('"EL CAMPO CEDULA NO PUEDE SER NULLO"');
      
   ELSE
      INSERT INTO PERSONAS (NOMBRE,
                            APELLIDO,
                            CEDULA,
                            CORREELECTRONICO,
                            ESTADO,
                            FECHANACIMIENTO,
                            FECHAREGISTRO,
                            FECHAACTUALIZACION)
           VALUES (V_NOMBRE,
                   V_APELLIDO,
                   V_CEDULA,
                   V_CORREELECTRONICO,
                   V_ESTADO,
                   V_FECHANACIMIENTO,
                   V_FECHAREGISTRO,
                   V_FECHAACTUALIZACION);

      DBMS_OUTPUT.PUT_LINE ('Registro Insertado');
   END IF;
  END IF;
EXCEPTION
   WHEN OTHERS  THEN
      DBMS_OUTPUT.PUT_LINE ('Error al insertar en la tabla Personas '||SQLERRM);
END;
/