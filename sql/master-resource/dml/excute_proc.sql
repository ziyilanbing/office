SET SQL_SAFE_UPDATES = 0;
delete from odh_prty_explain where ROLE_ID = '11';
call office.proc_case('11');
