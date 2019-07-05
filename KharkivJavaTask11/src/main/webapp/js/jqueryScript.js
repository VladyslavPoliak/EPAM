const email_regexp = /^[0-9a-zа-я_A-ZА-Я]+(\.[0-9a-zа-я_A-ZА-Я]+)*@[0-9a-zа-я_A-ZА-Я^.]+\.[a-zа-яА-ЯA-Z]{2,4}$/;
const names_regexp = /^[a-zа-я_A-ZА-Я]+(\s[a-zа-я_A-ZА-Я]+)*$/;

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
  addValidationClasses(userNameInput, checkers.validateByRegExp(names_regexp,$(userNameInput).val()));
}

function validateUserEmail(userEmailInput) {
  addValidationClasses(userEmailInput, checkers.validateByRegExp(email_regexp, $(userEmailInput).val()));
}

function validateUserSurname(userSurnameInput) {
  addValidationClasses(userSurnameInput, checkers.validateByRegExp(names_regexp,$(userSurnameInput).val()));
}

function validateUserPassword(userPasswordInput) {
  addValidationClasses(userPasswordInput, $(userPasswordInput).val().length > 5);
}

function validateUserConfirmPassword(userConfirmPasswordInput, userPasswordInput) {
  addValidationClasses(userConfirmPasswordInput, $(userPasswordInput).val() == $(userConfirmPasswordInput).val() && $(userConfirmPasswordInput).val().length != 0);
}

function validateRegistrationForm(registrationForm) {
  const registrationFormInputs = $(registrationForm).find('input');
  const userNameInput = $(registrationForm).find('[name="userName"]');
  const userSurnameInput = $(registrationForm).find('[name="userSurname"]');
  const userEmailInput = $(registrationForm).find('[name="userEmail"]');
  const userPasswordInput = $(registrationForm).find('[name="userPassword"]');
  const userConfirmPasswordInput = $(registrationForm).find('[name="confirmationPassword"]');

  validateUserName(userNameInput);
  validateUserEmail(userEmailInput);
  validateUserSurname(userSurnameInput);
  validateUserPassword(userPasswordInput);
  validateUserConfirmPassword(userConfirmPasswordInput, userPasswordInput);

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

  $(registrationForm).submit(handleRegistrationFormSubmit);
  $(userEmailInput).on('input', handleUserEmailInput);
  $(userNameInput).on('input', handleUserNameBlur);
  $(userSurnameInput).on('input', handleUserSurnameBlur);
  $(userPasswordInput).on('input', handleUserPasswordBlur);
  $(userConfirmPasswordInput).on('input', handleUserConfirmPasswordBlur);
}

initializeRegistrationFormValidation(registrationForm);