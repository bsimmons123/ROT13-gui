$(document).ready(function () {
    $("form").submit(function (event) {
        $.ajax({
            url         : 'cipher.start',
            method      : 'POST',
            data        : {
                input_value: document.getElementById('value_to_hash').value
            },
            success    : function(result){
                $('#result').html("<br><span style='font-style: italic; border-bottom: 2px solid green;'>CIPHER: </span>"+result.value);
                $('#originalInput').html("<br><span style='font-style: italic; border-bottom: 2px solid grey;'>ORIGINAL: </span>"+result.originalValue);
            },
            error : function(jqXHR, exception){
                console.log('Error occurred!!');
            }
        });
        event.preventDefault();
    })
});