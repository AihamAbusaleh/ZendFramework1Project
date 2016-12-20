 
 

function doValidation(id, actionUrl, formName) {

    function showErrors(resp) {
        $("#" + id).parent().parent().find('.errors').html(' ');
        $("#" + id).parent().parent().find('.errors').html(getErrorHtml(resp[id]));
    }

    $.ajax({
        type: 'POST',
        url: actionUrl,
        data: $("#" + formName).serialize(),
        dataType: 'json',
        success: showErrors
    });
}

function getErrorHtml(formErrors) {
    if ((typeof (formErrors) === 'undefined') || (formErrors.length < 1))
        return;

    var out = '<ul>';
    for (errorKey in formErrors) {
        out += '<li>' + formErrors[errorKey] + '</li>';
    }
    out += '</ul>';
    return out;
}



function deleletconfig() {
    var x = confirm("Are you sure you want to delete this Product ?");
    if (x)
        return true;
    else
 
        return false;
}

 