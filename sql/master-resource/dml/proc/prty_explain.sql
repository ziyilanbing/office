-- ----------------------------
-- Procedure structure for `proc_case`
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_case`;
DELIMITER $$
CREATE PROCEDURE `proc_case`(
	IN roleid VARCHAR(20)
)
BEGIN
-- 需要定义接收游标数据的变量 
	DECLARE menuid VARCHAR(20);   
	-- 跳出循环标识
	DECLARE done INT DEFAULT FALSE;
	-- 声明游标**/
	DECLARE cur CURSOR FOR select MENU_ID from sys_menu;
	-- 循环结束设置跳出标识
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	-- 打开游标
	OPEN cur;
    
	-- 开始循环
	LOOP_LABLE:loop
    -- 提取游标里的数据，这里只有一个，多个的话也一样
		FETCH cur INTO menuid;
        -- 声明结束的时候
		if done THEN
			LEAVE LOOP_LABLE;
		END IF;
		-- 循环的事件
		insert into `office`.`odh_prty_explain` (`model_id`,`role_id`,`LOGIN_NO`,`LOGIN_IP`,`REC_INSERT_TIME`,`UPDATE_NO`,`UPDATE_IP`,`REC_UPDATE_TIME`) values (menuid,roleid,'proc','0.0.0.1',sysdate(),'proc','0.0.0.1',sysdate());
	
    end LOOP;
     /**关闭游标**/
	CLOSE cur;
END$$
DELIMITER ;