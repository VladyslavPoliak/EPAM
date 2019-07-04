const EMAIL_REG_EXP = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

function addValidationClasses(field, isValid) {
  $(field).toggleClass('is-valid', isValid);
  $(field).toggleClass('is-invalid', !isValid);
}

const validateAfter3Chars = handler => value => value.length >= 3 && handler();

const checkers = {
  validateStringLength: string => Boolean(string.length),
  validateByRegExp: (regExp, value) => regExp.test(value)
};

function validateUserName(userNameInput) {
  addValidationClasses(userNameInput, checkers.validateStringLength($(userNameInput).val()));
}

function validateUserEmail(userEmailInput) {
  addValidationClasses(userEmailInput, checkers.validateByRegExp(EMAIL_REG_EXP, $(userEmailInput).val()));
}

function validateUserSurname(userSurnameInput) {
  addValidationClasses(userSurnameInput, checkers.validateStringLength($(userSurnameInput).val()));
}

function validateUserPassword(userPasswordInput) {
  addValidationClasses(userPasswordInput, $(userPasswordInput).val().length > 5);
}

function validateUserConfirmPassword(userConfirmPasswordInput, userPasswordInput) {
  addValidationClasses(userConfirmPasswordInput, $(userPasswordInput).val() == $(userConfirmPasswordInput).val() && $(userConfirmPasswordInput).val().length != 0);
}

function validateSelectGender(selectGender) {
  addValidationClasses(selectGender, $(selectGender).val().length > 1);
}

function validateRegistrationForm(registrationForm) {
  const registrationFormInputs = $(registrationForm).find('input');
  const userNameInput = $(registrationForm).find('[name="userName"]');
  const userSurnameInput = $(registrationForm).find('[name="userSurname"]');
  const userEmailInput = $(registrationForm).find('[name="userEmail"]');
  const userPasswordInput = $(registrationForm).find('[name="userPassword"]');
  const userConfirmPasswordInput = $(registrationForm).find('[name="confirmationPassword"]');

  const selectGender = $(registrationForm).find('[name="selectGender"]');

  validateUserName(userNameInput);
  validateUserEmail(userEmailInput);
  validateUserSurname(userSurnameInput);
  validateUserPassword(userPasswordInput);
  validateUserConfirmPassword(userConfirmPasswordInput, userPasswordInput);
  validateSelectGender(selectGender);

  return !registrationFormInputs.hasClass('is-invalid');
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
    validateUserEmail(event.target);
  });
  validateUserEmailAfter3Chars($(event.target).val());
}

function handleUserPasswordBlur(event) {
  validateUserPassword(event.target);
  console.log(event.target.password + ':' + event.target.value);
}

function handleUserConfirmPasswordBlur(event) {
  const registrationForm = $('#registration-form');
  const userPasswordInput = $(registrationForm).find('[name="userPassword"]');
  validateUserConfirmPassword(event.target, userPasswordInput);
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

const registrationForm = $('#registration-form');

function initializeRegistrationFormValidation(registrationForm) {
  const userNameInput = $(registrationForm).find('[name="userName"]');
  const userSurnameInput = $(registrationForm).find('[name="userSurname"]');
  const userEmailInput = $(registrationForm).find('[name="userEmail"]');
  const userPasswordInput = $(registrationForm).find('[name="userPassword"]');
  const userConfirmPasswordInput = $(registrationForm).find('[name="confirmationPassword"]');

  const selectGender = $(registrationForm).find('[name="selectGender"]');

  $(registrationForm).submit(handleRegistrationFormSubmit);
  $(userEmailInput).on('input', handleUserEmailInput);
  $(userNameInput).on('input', handleUserNameBlur);
  $(userSurnameInput).on('input', handleUserSurnameBlur);
  $(userPasswordInput).on('input', handleUserPasswordBlur);
  $(userConfirmPasswordInput).on('input', handleUserConfirmPasswordBlur);
  $(selectGender).on('input', handleUserGender)
}

initializeRegistrationFormValidation(registrationForm);