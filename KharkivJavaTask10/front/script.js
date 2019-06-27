// Constants './constants.js'
const EMAIL_REG_EXP = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

// Utils './utils.js'

function addValidationClasses(field, isValid) {
  field.classList.toggle('is-valid', isValid);
  field.classList.toggle('is-invalid', !isValid);
}

const validateAfter3Chars = handler => value => value.length >= 3 && handler();

// Validation utils './validation-utils.js'

const checkers = {
  validateStringLength: string => Boolean(string.length),
  validateByRegExp: (regExp, value) => regExp.test(value)
};

// Registration Form Validation './registration-form-validation.js'

function validateUserName(userNameInput) {
  addValidationClasses(userNameInput, checkers.validateStringLength(userNameInput.value));
}

function validateUserEmail(userEmailInput) {
  addValidationClasses(userEmailInput, checkers.validateByRegExp(EMAIL_REG_EXP, userEmailInput.value));
}

function validateUserSurname(userSurnameInput) {
  addValidationClasses(userSurnameInput, checkers.validateStringLength(userSurnameInput.value));
}

function validateUserPassword(userPasswordInput) {
  addValidationClasses(userPasswordInput, userPasswordInput.value.length > 4);
}

function validateUserConfirmationPassword(userPasswordConfirmationInput, userPasswordInput) {
  addValidationClasses(userPasswordConfirmationInput, userPasswordConfirmationInput.value == userPasswordInput.value &&checkers.validateStringLength(userSurnameInput.value));
}

function validateSelectGender(selectGender) {
  addValidationClasses(selectGender, selectGender.value.length > 1);
}

function validateRegistrationForm(registrationForm) {
  const registrationFormInputs = registrationForm.querySelectorAll(':scope input');
  const registrationFormInputsArray = Array.prototype.slice.call(registrationFormInputs);
  const userNameInput = registrationForm.elements.userName;
  const userSurnameInput = registrationForm.elements.userSurname;
  const userEmailInput = registrationForm.elements.userEmail;
  const userPasswordInput = registrationForm.elements.userPassword;
  const userPasswordConfirmationInput = registrationForm.elements.confirmationPassword;

  const selectGender = registrationForm.elements.selectGender;

  validateUserName(userNameInput);
  validateUserEmail(userEmailInput);
  validateUserSurname(userSurnameInput);
  validateUserPassword(userPasswordInput);
  validateUserConfirmationPassword(userPasswordConfirmationInput, userPasswordInput);
  validateSelectGender(selectGender);

  return !registrationFormInputsArray.some(input => input.classList.contains('is-invalid'));
}

// Registration Form Handlers './registration-form-handlers.js'

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
    validateUserEmail(event.target);
  });
  validateUserEmailAfter3Chars(event.target.value);
}

function handleUserPasswordBlur(event) {
  validateUserPassword(event.target);
  console.log(event.target.password + ':' + event.target.value);
}

function handleUserPasswordConfirmation(event) {
  validateUserConfirmationPassword(event.target, userPasswordInput);
  console.log(event.target.password + ':' + event.target.value);
}

function handleUserGender(event) {
  validateSelectGender(event.target);
}

function handleRegistrationFormSubmit(event) {
  const isValid = validateRegistrationForm(event.target);

  if (!isValid) {
    event.preventDefault();
  }
}

// Registration Form './registration-form.js'

const registrationForm = document.getElementById('registration-form');

function initializeRegistrationFormValidation(registrationForm) {
  const userNameInput = registrationForm.elements.userName;
  const userSurnameInput = registrationForm.elements.userSurname;
  const userEmailInput = registrationForm.elements.userEmail;
  const userPasswordInput = registrationForm.elements.userPassword;
  const userPasswordConfirmationInput = registrationForm.elements.confirmationPassword;

  const selectGender = registrationForm.elements.selectGender;

  registrationForm.addEventListener('submit', handleRegistrationFormSubmit);
  userEmailInput.addEventListener('input', handleUserEmailInput);
  userNameInput.addEventListener('input', handleUserNameBlur);
  userSurnameInput.addEventListener('input', handleUserSurnameBlur);
  userPasswordInput.addEventListener('input', handleUserPasswordBlur);
  userPasswordConfirmationInput.addEventListener('input', handleUserPasswordConfirmation);

  selectGender.addEventListener('input', handleUserGender);

}

initializeRegistrationFormValidation(registrationForm);