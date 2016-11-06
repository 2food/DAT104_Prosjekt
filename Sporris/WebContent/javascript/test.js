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
    
    $("body").on("click", "input.toggle-button", function(){
        $(this).toggle();
        $(this).siblings().toggle();
        $(this).parent().parent().find("li").toggle();
    });
    
    $("body").on("click", "input.remove-parent", function(){
        $(this).parent().remove();
        
    });
    
    remove-parent
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
    line += '<div class="extend-control"><input type="button" value="Lukk" class="button toggle-button"><input type="button" value="Utvid" class="button toggle-button" style="display:none"></div>';
    line += '<div class="question-container">Sp&oslashrsm&aringl:<br /><input type="text" name="newQ_' + counter + '">';
    line += '<ul class="alternatives"><li class="alternative"><input type="checkbox" name ="newQ_' + counter + '_text" value="newQ_' + counter + '_text">Fritekst</li>';
    line += newAlternativeButton();
    line += '</ul></div></li>';
    return line;
}

function newAlternative(qName, aCounter) {
    var line = '<li class="alternative">Alternativ#: <input type="text" name="' + qName + '_aid_' + aCounter + '">';
    line += '<input class="remove-parent" type="button" value="X"></li>';
    return line;
}

function newAlternativeButton() {
    var line = '<li class="alternative"><input type="button" value="Legg til alternativ" class="button add-alternative-button"></li>';
    return line;
}

function newQuestionButton() {
    var line = '<li class="question"><input type="button" value="Legg til sp<&oslash>rsm<&aring>l" class="button add-question-button"></li>';
    return line;
}