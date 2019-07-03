// Constants './constants.js'
const EMAIL_REG_EXP = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

// Utils './utils.js'

function addValidationClasses(field, isValid) {
  $(field).toggleClass('is-valid', isValid);
  $(field).toggleClass('is-invalid', !isValid);
}

const validateAfter3Chars = handler => value => value.length >= 3 && handler();

// Validation utils './validation-utils.js'

const checkers = {
  validateStringLength: string => Boolean(string.length),
  validateByRegExp: (regExp, value) => regExp.test(value)
};

// Registration Form Validation './registration-form-validation.js'

function validateUserName(userNameInput) {
  addValidationClasses(userNameInput, checkers.validateStringLength($(userNameInput).val()));
}

function validateUserEmail(userEmailInput) {
  addValidationClasses(userEmailInput, checkers.validateByRegExp(EMAIL_REG_EXP, $(userEmailInput).val()));
}

function validateUserLogin(userLoginInput) {
  addValidationClasses(userLoginInput, checkers.validateStringLength($(userLoginInput).val()));
}

function validateUserPassword(userPasswordInput) {
  addValidationClasses(userPasswordInput, $(userPasswordInput).val().length >= 7);
}

function validateUserConfirmPassword(userConfirmPasswordInput, userPasswordInput) {
  addValidationClasses(userConfirmPasswordInput, $(userPasswordInput).val() == $(userConfirmPasswordInput).val() && $(userConfirmPasswordInput).val().length != 0);
}

function validateRegistrationForm(registrationForm) {
  const registrationFormInputs = $(registrationForm).find('input');
  const userNameInput = $(registrationForm).find('[name="userName"]');
  const userLoginInput = $(registrationForm).find('[name="userLogin"]');
  const userEmailInput = $(registrationForm).find('[name="userEmail"]');
  const userPasswordInput = $(registrationForm).find('[name="userPassword"]');
  const userConfirmPasswordInput = $(registrationForm).find('[name="userConfirmPassword"]');


  validateUserName(userNameInput);
  validateUserEmail(userEmailInput);
  validateUserLogin(userLoginInput);
  validateUserPassword(userPasswordInput);
  validateUserConfirmPassword(userConfirmPasswordInput, userPasswordInput);


  return !registrationFormInputs.hasClass('is-invalid');
}

// Registration Form Handlers './registration-form-handlers.js'

function handleUserNameBlur(event) {
  validateUserName(event.target);
}

function handleUserLoginBlur(event) {
  validateUserLogin(event.target);
}


function handleUserEmailInput(event) {
  const validateUserEmailAfter3Chars = validateAfter3Chars(() => {
    validateUserEmail(event.target);
  });
  validateUserEmailAfter3Chars($(event.target).val());
}

function handleUserPasswordBlur(event) {
  validateUserPassword(event.target);
}

function handleUserConfirmPasswordBlur(event) {
  const registrationForm = $('#registration-form');
  const userPasswordInput = $(registrationForm).find('[name="userPassword"]');
  validateUserConfirmPassword(event.target, userPasswordInput);
}

function handleRegistrationFormSubmit(event) {
  const isValid = validateRegistrationForm(event.target);

  if (!isValid) {
    event.preventDefault();
  }
}

// Registration Form './registration-form.js'

const registrationForm = $('#registration-form');

function initializeRegistrationFormValidation(registrationForm) {
  const userNameInput = $(registrationForm).find('[name="userName"]');
  const userLoginInput = $(registrationForm).find('[name="userLogin"]');
  const userEmailInput = $(registrationForm).find('[name="userEmail"]');
  const userPasswordInput = $(registrationForm).find('[name="userPassword"]');
  const userConfirmPasswordInput = $(registrationForm).find('[name="userConfirmPassword"]');

  $(registrationForm).submit(handleRegistrationFormSubmit);
  $(userEmailInput).on('input', handleUserEmailInput);
  $(userNameInput).on('input', handleUserNameBlur);
  $(userLoginInput).on('input', handleUserLoginBlur);
  $(userPasswordInput).on('input', handleUserPasswordBlur);
  $(userConfirmPasswordInput).on('input', handleUserConfirmPasswordBlur);
}

initializeRegistrationFormValidation(registrationForm);