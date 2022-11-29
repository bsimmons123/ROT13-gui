$(document).ready(function () {
    $("form").submit(function (event) {
        $.ajax({
            url         : 'cipher.start',
            method      : 'POST',
            data        : {
                input_value: document.getElementById('value_to_hash').value
            },
            success    : function(resultText){
                const res = JSON.parse(resultText);
                $('#result').html("<br><span style='font-style: italic; border-bottom: 2px solid green;'>CIPHER: </span>"+res.hashedValues);
            },
            error : function(jqXHR, exception){
                console.log('Error occurred!!');
            }
        });
        event.preventDefault();
    })
});