$(document).ready(function(){
	var qCounter = 0;
	var aCounter = 0;
    $('#questions').html(function(i, ot) {
		return ot + newQuestionButton();
	});
    
    $("body").on("click", ".add-alternative-button", function(){
		aCounter = newAId(aCounter);
		qName = $(this).parent().parent().siblings('input').attr('name');
        $(this).parent().parent().append(newAlternative(qName, aCounter));
        $(this).parent().parent().append(newAlternativeButton());
        $(this).parent().remove();
    });
    
    $("body").on("click", ".add-question-button", function(){
		qCounter = newQId(qCounter);
        $(this).parent().parent().append(newQuestion(qCounter));
        $(this).parent().parent().append(newQuestionButton());
        $(this).parent().remove();
    });
    
    $("body").on("click", "button.toggle-button", function(){
		$(this).toggle();
        $(this).siblings().toggle();
        $(this).parent().parent().find(".alternatives").toggle();
    });
    
    $("body").on("click", "button.remove-parent", function(){
        $(this).parent().remove();
        
    });
    
});

function newQId(qCounter) {
	counter = qCounter +1;
	$("#newQCounter").val(counter);
	return counter;
}
function newAId(aCounter) {
	counter = aCounter +1;
	$("#newACounter").val(counter);
	return counter;
}

function newQuestion(counter) {
	var line = '<li class="question">';
    line += '<div class="extend-control"><button type="button" class="toggle-button">Lukk</button><button type="button" class="toggle-button" style="display:none">Utvid</button></div>';
    line += '<div class="question-container">Sp&oslashrsm&aringl:<br /><input type="text" name="newQ_' + counter + '">';
    line += '<ul class="alternatives"><li class="alternative"><input type="checkbox" name ="newQ_' + counter + '_text">Fritekst</li>';
    line += newAlternativeButton();
    line += '</ul></div></li>';
    return line;
}

function newAlternative(qName, aCounter) {
    var line = '<li class="alternative">Alternativ#: <input type="text" name="' + qName + '_aid_' + aCounter + '">';
    line += '<button type="button" class="remove-parent">X</button></li>';
    return line;
}

function newAlternativeButton() {
    var line = '<li class="alternative"><button type="button" class="button add-alternative-button">Legg til alternativ</button></li>';
    return line;
}

function newQuestionButton() {
	var line = '<li class="question"><button type="button" class="button add-question-button">Legg til Sp&oslashrsm&aringl</button></li>';
    return line;
}