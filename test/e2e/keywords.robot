*** Variables ***
${URL}    http://localhost:4200/login

*** Keywords ***
add
    [Arguments]    ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${ACTION}    ${USER_ID}    ${FORM_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}    ${DATE_OF_BIRTH}    ${POSITION}    ${PHONE_NUMBER}    ${ADDRESS}    ${START_DATE}    ${POST_CODE}    ${ID_CARD}
    Open what is good in pattaya browser
    Click Login button
    Change to action page
    Click add button
    Show add page work message
    # Fill employee's info    ${USER_ID}    ${NAME}    ${SURNAME}    ${DATE_OF_BIRTH}    ${POSITION}    ${PHONE_NUMBER}    ${ADDRESS}    ${START_DATE}    ${MESSAGE}    ${POST_CODE}    ${ID_CARD}
    # Click submit button
    # Change to history page    ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${FORM_ID}    ${ACTION}    ${USER_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}
    Close what is good in pattaya browser

edit
    [Arguments]    ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${ACTION}    ${USER_ID}    ${FORM_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}    ${DATE_OF_BIRTH}    ${POSITION}    ${PHONE_NUMBER}    ${ADDRESS}    ${START_DATE}    ${POST_CODE}    ${ID_CARD}
    Open what is good in pattaya browser
    Click Login button
    Change to action page
    Click edit button
    Show edit page work message
    # Show employee's info that want to edit    ${USER_ID}    ${NAME}    ${ID_CARD}
    # Edit employee's info    ${SURNAME}    ${MESSAGE}
    # Click save button
    # Change to history page   ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${FORM_ID}    ${ACTION}    ${USER_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}
    Close what is good in pattaya browser
    
delete
    [Arguments]    ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${ACTION}    ${USER_ID}    ${FORM_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}    ${DATE_OF_BIRTH}    ${POSITION}    ${PHONE_NUMBER}    ${ADDRESS}    ${START_DATE}    ${POST_CODE}    ${ID_CARD}
    Open what is good in pattaya browser
    Click Login button
    Change to action page
    Click delete button
    Show edit page work message
    # Show employee's info that want to delete    ${USER_ID}    ${NAME}    ${ID_CARD}
    # Click delete button to confirm
    # Change to history page    ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${FORM_ID}    ${ACTION}    ${USER_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}
    Close what is good in pattaya browser

Open what is good in pattaya browser
    Open Browser    ${URL}    chrome
    Sleep    1

Close what is good in pattaya browser
    Close Browser

Click Login button
    Click Button    id: login_btn
    Sleep    1

Change to action page
    Wait Until Page Contains Element    id: add_btn
    Wait Until Page Contains Element    id: edit_btn
    Wait Until Page Contains Element    id: delete_btn
    Wait Until Page Contains Element    id: history_btn
    Sleep    1

Click add button
    Click Button    id: add_btn
    Sleep    1

# Fill employee's info
#     [Arguments]    ${USER_ID}    ${NAME}    ${SURNAME}    ${DATE_OF_BIRTH}    ${POSITION}    ${PHONE_NUMBER}    ${ADDRESS}    ${START_DATE}    ${MESSAGE}    ${POST_CODE}    ${ID_CARD}
#     Input Text    id: user_id    ${USER_ID}
#     Input Text    id: firstname    ${NAME}
#     Input Text    id: lastname    ${SURNAME}
#     Input Text    id: id_card    ${ID_CARD}
#     Input Text    id: date_of_birth    ${DATE_OF_BIRTH}
#     Input Text    id: position    ${POSITION}
#     Input Text    id: phone_number    ${PHONE_NUMBER}
#     Input Text    id: address    ${ADDRESS}
#     Input Text    id: post_code    ${POST_CODE}    
#     Input Text    id: start_dtae    ${START_DATE}
#     Input Text    id: message    ${MESSAGE}

# Click submit button
#     Click Button    id: submit_btn

# Change to history page
#     [Arguments]    ${MESSAGE}    ${ADMIN_ID}    ${ADMIN_USER}    ${FORM_ID}    ${ACTION}    ${USER_ID}    ${NAME}    ${SURNAME}    ${TIMESTAMP}
#     Table Should Contain    id: table_history    ${MESSAGE}
#     Table Cell Should Contain    row=2    column=2    ${ADMIN_ID}
#     Table Cell Should Contain    row=2    column=3    ${ADMIN_USER}
#     Table Cell Should Contain    row=2    column=4    ${ACTION}
#     Table Cell Should Contain    row=2    column=5    ${USER_ID}
#     Table Cell Should Contain    row=2    column=6    ${NAME}    ${SURNAME}
#     Table Cell Should Contain    row=2    column=8    ${MESSAGE}

Click edit button
    Click Button    id: edit_btn
    Sleep    1

# Show employee's info that want to edit
#     [Arguments]    ${USER_ID}    ${NAME}    ${ID_CARD}
#     Wait Until Element Contains    id: user_id    ${USER_ID}
#     Wait Until Element Contains    id: firstname    ${NAME} 
#     Wait Until Element Contains    id: id_card    ${ID_CARD}

# Edit employee's info
#     [Arguments]    ${SURNAME}    ${MESSAGE}
#     Clear Element Text    id: lastname    
#     Input Text    id: lastname    ${SURNAME}
#     Clear Element Text    id: message
#     Input Text    id: message    ${MESSAGE}

# Click save button
#     Click Button    id: save_btn

Click delete button
    Click Button    id: delete_btn
    Sleep    1

# Show employee's info that want to delete
#     [Arguments]    ${USER_ID}    ${NAME}    ${ID_CARD}
#     Wait Until Element Contains    id: user_id    ${USER_ID}
#     Wait Until Element Contains    id: firstname    ${NAME} 
#     Wait Until Element Contains    id: id_card    ${ID_CARD}

# Click delete button to confirm
#     Click Button    id: delete_btn

Show add page work message
    Wait Until Page Contains    form works!
    Sleep    1

Show edit page work message
    Wait Until Page Contains    edit works!
    Sleep    1
