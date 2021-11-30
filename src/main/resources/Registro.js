var btnRegistro = document.getElementById("btnRegistro");

btnRegistro.addEventListener("click", function() {

    var usuario = document.getElementById("user").value;
    var contraseña = document.getElementById("password").value;

    axios.post("http://localhost:4567/registrarUsuario", {

        usuario : usuario,
        contraseña : contraseña

    })
        .then(function(response) {

            console.log(response.data);
            alert("Usuario registrado");

        })

        .catch(function(error) {

            console.log(error);
            alert("Error al registrarte :(");

        })

});

let checked = null;

for (let checkBox of document.getElementsByClassName('claseCheck')){

    checkBox.onclick = function(){

      if(checked!=null){
      checked.checked = false;
      checked = checkBox;
      
    }

    checked = checkBox;
  }
}