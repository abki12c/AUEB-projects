ENTITY askisi3 IS
    PORT (x1,x2,x3  : IN  BIT;
          f         : OUT BIT);
END askisi3;

ARCHITECTURE Behavior OF askisi3 IS
BEGIN
   f <= x2 OR (NOT x1 AND x3);
END Behavior;