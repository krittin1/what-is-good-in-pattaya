*** Settings ***
Resource    keywords.robot
Library     SeleniumLibrary
Test Teardown    Close Form Browser

*** Test Cases ***                                                               MESSAGE                             ADMIN_ID          ADMIN_USER            ACTION         USER_ID          FORM_ID            NAME                 SURNAME            TIMESTAMP                    DATE_OF_BIRTH        POSITION                    PHONE_NUMBER          ADDRESS          START_DATE          POST_CODE          ID_CARD                
Admin Chatchanokwon Add Nattawitjan's Information - 11/08/2020 at 11.20 A.M.
    Add New Employee                                                             Added user 251170                     251195            chatchanokwon         Added           251170          001                Nattawit             Janjaroen          11/08/2020 11.20 A.M.        27/09/1995           Junior Backend Developer    0824933423            Bangkok          01/07/2020          10200              1111111111111
Admin Chatchanokwon Edit Veeraphatamo's Information - 11/08/2020 at 04.30 P.M.
    Edit Employee's Information                                                  Changed [last name] of user 251161   251195            chatchanokwon         Edited          251161          005                Veeraphat            Amornsirikul       11/08/2020 01.30 P.M.        11/10/1997           Junior Backend Developer    0953569497            Bangkok          01/07/2020          10200              1111111111111
Admin Chatchanokwon Delete Jirapornkan's Information - 11/08/2020 at 01.30 P.M.
    Delete Employee's Information                                                Deleted user 251184              251195            chatchanokwon         Deleted      251164          003                Jiraporn             Kanhasinwattana    11/08/2020 04.30 P.M.        11/03/1997           Junior Frontend develop     0918581202            Lampang          01/07/2020          10200              1111111111111

