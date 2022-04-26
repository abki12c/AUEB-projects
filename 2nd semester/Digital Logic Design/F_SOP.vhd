library ieee;
use ieee.std_logic_1164.all;

entity or_3 is 
port(in1,in2,in3:in std_logic;
		output:out std_logic);
end or_3;

architecture o3 of or_3 is
begin 
	output<=in1 or in2 or in3;
end o3;


library ieee;
use ieee.std_logic_1164.all;

entity and_2 is
port(in1,in2:in std_logic;
		output:out std_logic);
end and_2;

architecture a2 of and_2 is
begin 
	output<=in1 and in2;
end a2;

library ieee;
use ieee.std_logic_1164.all;

entity and_3 is 
port(in1,in2,in3:in std_logic;
		output:out std_logic);
end and_3;


architecture a3 of and_3 is
begin
	output<=in1 and in2 and in3;
end a3;


library ieee;
use ieee.std_logic_1164.all;

ENTITY F_SOP IS 
	PORT(x1,x2,x3,x4,x5:IN std_logic;
			f:OUT std_logic);
END F_SOP;


ARCHITECTURE F_SOP_A OF F_SOP IS 

	component and_2
		port(in1,in2:in std_logic;
				output:out std_logic);
	end component;
	
	component or_3
		port(in1,in2,in3:in std_logic;
				output:out std_logic);
	end component;
	
	component and_3
		port(in1,in2,in3:in std_logic;
				output:out std_logic);
	end component;

	signal s1,s2,s3:std_logic;
	
BEGIN
	
	Step0:and_2 port map(not x1,not x2,s1);
	Step1:and_2 port map(x2,not x3,s2);
	Step2:and_3 port map(x1,x2,x5,s3);
	Step3:or_3 port map(s1,s2,s3,f);


END F_SOP_A;

	


