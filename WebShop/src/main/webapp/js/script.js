const email_regexp = /^[0-9a-zа-я_A-ZА-Я]+(\.[0-9a-zа-я_A-ZА-Я]+)*@[0-9a-zа-я_A-ZА-Я^.]+\.[a-zа-яА-ЯA-Z]{2,4}$/;
const names_regexp = /^[a-zа-я_A-ZА-Я]+(\s[a-zа-я_A-ZА-Я]+)*$/;

function addValidationClasses(field, isValid) {
    field.classList.toggle('is-valid', isValid);
    field.classList.toggle('is-invalid', !isValid);
}

const validateAfter3Chars = handler =>value =>value.length >= 3 && handler();

const checkers = {
        validateStringLength: string => Boolean(string.length),
    validateByRegExp
:
(regExp, value) =>
regExp.test(value)
}
;

function validateUserName(userNameInput) {
    addValidationClasses(userNameInput, checkers.validateByRegExp(names_regexp, userNameInput.value));
}

function validateUserEmail(userEmailInput) {
    addValidationClasses(userEmailInput, checkers.validateByRegExp(email_regexp, userEmailInput.value));
}

function validateUserSurname(userSurnameInput) {
    addValidationClasses(userSurnameInput, checkers.validateByRegExp(names_regexp, userSurnameInput.value));
}

function validateUserPassword(userPasswordInput) {
    addValidationClasses(userPasswordInput, userPasswordInput.value.length > 5);
}

function validateUserConfirmationPassword(userPasswordConfirmationInput, userPasswordInput) {
    addValidationClasses(userPasswordConfirmationInput, userPasswordConfirmationInput.value == userPasswordInput.value);
}

function validateRegistrationForm(registrationForm) {
    const registrationFormInputs = registrationForm.querySelectorAll(':scope input');
    const registrationFormInputsArray = Array.prototype.slice.call(registrationFormInputs);
    const userNameInput = registrationForm.elements.userName;
    const userSurnameInput = registrationForm.elements.userSurname;
    const userEmailInput = registrationForm.elements.userEmail;
    const userPasswordInput = registrationForm.elements.userPassword;
    const userPasswordConfirmationInput = registrationForm.elements.confirmationPassword;

    validateUserName(userNameInput);
    validateUserEmail(userEmailInput);
    validateUserSurname(userSurnameInput);
    validateUserPassword(userPasswordInput);
    validateUserConfirmationPassword(userPasswordConfirmationInput, userPasswordInput);

    return !registrationFormInputsArray.some(input => input.classList.contains('is-invalid')
)
    ;
}

function handleUserNameBlur(event) {
    validateUserName(event.target);
    console.log(event.target.name + ':' + event.target.value);
}

function handleUserSurnameBlur(event) {
    validateUserSurname(event.target);
    console.log(event.target.surname + ':' + event.target.value);
}

function handleUserEmailInput(event) {
    const validateUserEmailAfter3Chars = validateAfter3Chars(() => {
        validateUserEmail(event.target
)
    ;
})
    ;
    validateUserEmailAfter3Chars(event.target.value);
}

function handleUserPasswordBlur(event) {
    validateUserPassword(event.target);
    console.log(event.target.password + ':' + event.target.value);
}

function handleUserPasswordConfirmation(event) {
    validateUserConfirmationPassword(event.target, registrationForm.elements.userPassword);
    console.log(event.target.password + ':' + event.target.value);
}

function handleRegistrationFormSubmit(event) {
    const isValid = validateRegistrationForm(event.target);

    if (!isValid) {
        event.preventDefault();
    }
}

const registrationForm = document.getElementById('registration-form');

function initializeRegistrationFormValidation(registrationForm) {
    const userNameInput = registrationForm.elements.userName;
    const userSurnameInput = registrationForm.elements.userSurname;
    const userEmailInput = registrationForm.elements.userEmail;
    const userPasswordInput = registrationForm.elements.userPassword;
    const userPasswordConfirmationInput = registrationForm.elements.confirmationPassword;

    registrationForm.addEventListener('submit', handleRegistrationFormSubmit);
    userEmailInput.addEventListener('input', handleUserEmailInput);
    userNameInput.addEventListener('input', handleUserNameBlur);
    userSurnameInput.addEventListener('input', handleUserSurnameBlur);
    userPasswordInput.addEventListener('input', handleUserPasswordBlur);
    userPasswordConfirmationInput.addEventListener('input', handleUserPasswordConfirmation);

}

initializeRegistrationFormValidation(registrationForm);