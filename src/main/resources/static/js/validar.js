const email = document.getElementById("idm");

email.addEventListener("input", function (event) {
  if (email.validity.typeMismatch) {
    email.setCustomValidity("¡Ingresar datos!");
  } else {
    email.setCustomValidity("");
  }
});
