var btnRegistro = document.getElementById("btnRegistro");

btnRegistro.addEventListener("click", function() {

    var usuario = document.getElementById("user").value;
    var contraseña = document.getElementById("password").value;
    var rol
    
    if(document.getElementById("checkProfesor").checked) {

        rol = "profesor";

    } else {

        if(document.getElementById("checkAlumno").checked) {

            rol = "alumno";
    
        } else {

            alert("No se selecciono el rol :(");
            location.reload();

        }

    }

    axios.post("http://localhost:4567/registrarUsuario", {

        usuario : usuario,
        contraseña : contraseña,
        rol : rol

    })
        .then(function(response) {

            alert(response.data.status + " con nombre: " + response.data.nombre);

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