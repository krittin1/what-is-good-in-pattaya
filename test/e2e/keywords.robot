*** Variables ***
${URL}    https://what-is-good-in-pattaya.com

*** Keywords ***
# Check Log
Admin Chatchanokwon add Nattawitjan's information - 11/08/2020 at 11.20 A.M.
    [Arguments]    ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${ACTION}    ${USER_ID}    ${FORM_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}    ${DATE_OF_BIRTH}    ${POSITION}    ${PHONE_NUMBER}    ${ADDRESS}    ${START_DATE}    ${POST_CODE}    ${ID_CARD}
    Open Browser
    Click Login button
    Change to action page
    Click add button
    Fill employee's info    ${USER_ID}    ${NAME}    ${SURNAME}    ${DATE_OF_BIRTH}    ${POSITION}    ${PHONE_NUMBER}    ${ADDRESS}    ${START_DATE}    ${MESSAGE}    ${POST_CODE}    ${ID_CARD}
    Click submit button
    Change to history page    ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${FORM_ID}    ${ACTION}    ${USER_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}
    Close Browser

Admin Chatchanokwon edit Veeraphatamo's information - 11/08/2020 at 04.30 P.M
    Open Browser
    Click Login button
    Change to action page
    Click edit button
    Show employee's info that want to edit    ${USER_ID}    ${NAME}    ${ID_CARD}
    Edit employee's info    ${SURNAME}    ${MESSAGE}
    Click save button
    Change to history page   ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${FORM_ID}    ${ACTION}    ${USER_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}
    Close Browser
    
Admin Chatchanokwon delete Jirapornkan's information - 11/08/2020 at 01.30 P.M.
    Open Browser
    Click Login button
    Change to action page
    Click delete button
    Show employee's info that want to delete    ${USER_ID}    ${NAME}    ${ID_CARD}
    Click delete button to confirm
    Change to history page    ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${FORM_ID}    ${ACTION}    ${USER_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}
    Close Browser

Open Browser
    Open Browser    ${URL}    chrome

Close Browser
    Close Browser

Click Login button
    Click Button    id: login_btn

Change to action page
    Wait Until Element Contains    id: add_btn
    Wait Until Element Contains    id: edit_btn
    Wait Until Element Contains    id: delete_btn
    Wait Until Element Contains    id: history_btn

Click add button
    Click Button    id: add_btn

Fill employee's info
    [Arguments]    ${USER_ID}    ${NAME}    ${SURNAME}    ${DATE_OF_BIRTH}    ${POSITION}    ${PHONE_NUMBER}    ${ADDRESS}    ${START_DATE}    ${MESSAGE}    ${POST_CODE}    ${ID_CARD}
    Input Text    id: user_id    ${USER_ID}
    Input Text    id: firstname    ${NAME}
    Input Text    id: lastname    ${SURNAME}
    Input Text    id: id_card    ${ID_CARD}
    Input Text    id: date_of_birth    ${DATE_OF_BIRTH}
    Input Text    id: position    ${POSITION}
    Input Text    id: phone_number    ${PHONE_NUMBER}
    Input Text    id: address    ${ADDRESS}
    Input Text    id: post_code    ${POST_CODE}    
    Input Text    id: start_dtae    ${START_DATE}
    Input Text    id: message    ${MESSAGE}

Click submit button
    Click Button    id: submit_btn

Change to history page
    [Arguments]    ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${FORM_ID}    ${ACTION}    ${USER_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}
    Table Should Contain    id: table_history    ${MESSAGE}
    Table Cell Should Contain    row=2    column=2    ${ADMIN_ID}
    Table Cell Should Contain    row=2    column=3    ${ADMIN_USER}
    Table Cell Should Contain    row=2    column=4    ${ACTION}
    Table Cell Should Contain    row=2    column=5    ${USER_ID}
    Table Cell Should Contain    row=2    column=6    ${NAME}    ${SURNAME}
    Table Cell Should Contain    row=2    column=8    ${MESSAGE}

Click edit button
    Click Button    id: edit_btn

Show employee's info that want to edit
    [Arguments]    ${USER_ID}    ${NAME}    ${ID_CARD}
    Wait Until Element Contains    id: user_id    ${USER_ID}
    Wait Until Element Contains    id: firstname    ${NAME} 
    Wait Until Element Contains    id: id_card    ${ID_CARD}

Edit employee's info
    [Arguments]    ${SURNAME}    ${MESSAGE}
    Clear Element Text    id: lastname    
    Input Text    id: lastname    ${SURNAME}
    Clear Element Text    id: message
    Input Text    id: message    ${MESSAGE}

Click save button
    Click Button    id: save_btn

Click delete button
    Click Button    id: delete_btn

Show employee's info that want to delete
    [Arguments]    ${USER_ID}    ${NAME}    ${ID_CARD}
    Wait Until Element Contains    id: user_id    ${USER_ID}
    Wait Until Element Contains    id: firstname    ${NAME} 
    Wait Until Element Contains    id: id_card    ${ID_CARD}

Click delete button to confirm
    Click Button    id: delete_btn
