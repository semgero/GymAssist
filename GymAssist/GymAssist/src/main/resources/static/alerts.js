$('#btn_pagos').click(function(e) {
    e.preventDefault(); 
    
    Swal.fire({
        title: "Pago Recibido",
        text: "¡Ya puedes registrarte!",
        icon: "success",
        confirmButtonText: "Continuar"
    }).then((result) => {
        if (result.isConfirmed) {
            // Envía el formulario manualmente
            $(this).closest('form').submit();
        }
    });
});

$('#btn_configuracion').click(function(e) {
    e.preventDefault(); 
    
    Swal.fire({
        title: "Cambios Guardados",
        text: "¡Contraseña actualizada correctamente!",
        icon: "success",
        confirmButtonText: "Continuar"
    }).then((result) => {
        if (result.isConfirmed) {
            // Envía el formulario manualmente
            $(this).closest('form').submit();
        }
    });
});