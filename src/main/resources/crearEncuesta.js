var btnAgregarPregunta = document.getElementById("btnAgregar");

var listaPreguntas = document.getElementById("preguntasLista");

var player;
var contPreguntas = 0;

let arrayURL = document.getElementById("inputVideo").value.split("=");

btnAgregarPregunta.addEventListener("click", function() {

    if(contPreguntas <= 9) {

        let contenedorPregunta = document.createElement("li");
        let pregunta = document.createElement("div");
        let labelPregunta = document.createElement("label");
        let btnBorrar = document.createElement("button");
        let btnRespuestas = document.createElement("button");

        let videoPregunta = document.createElement("video");

        let videoArchivo = document.getElementById("inputVideo");

        pregunta.style.border = "thin solid #00CC66";
        pregunta.style.marginTop = "20px";
        pregunta.style.padding = "30px";
        pregunta.style.display = "flex";
        pregunta.style.justifyContent = "center";
        pregunta.style.alignItems = "center"; 

        videoPregunta.width = "400";
        videoPregunta.controls = "true";
        videoPregunta.src = URL.createObjectURL(videoArchivo.files[0]);

        btnBorrar.style.marginRight = "20px";
        btnRespuestas.style.marginRight = "20px";

        labelPregunta.innerHTML = document.getElementById("inputPregunta").value;
        btnBorrar.innerHTML = "Borrar pregunta";
        btnRespuestas.innerHTML = "Agregar respuesta";

        pregunta.appendChild(labelPregunta);
        pregunta.appendChild(btnBorrar);
        pregunta.appendChild(btnRespuestas);
        pregunta.appendChild(videoPregunta);

        contenedorPregunta.appendChild(pregunta);

        listaPreguntas.appendChild(contenedorPregunta);

        contPreguntas ++;

        guardarVideo(videoArchivo.files[0]);

    } else {

        btnAgregarPregunta.disabled = true;
        alert("No se peuden agregar mas preguntas, solo un maximo de 10");

    }

})

function guardarVideo(stream) {

    var formData = new FormData();
    formData.append("videoPregunta", stream);
    axios.post("http://localhost:4567/guardarVideo", formData, {

        headers: {

            "Content-Type" : "multipart/form-data"

        }

    })
        .then(function(response) {

            alert(response.data);

        })

        .catch(function(error) {

            console.log(error);
            alert("No se pudo guardar en video");

        })
}

//--------------------------------------------------------------------------------

var btnBorrarPregunta = document.getElementById("")