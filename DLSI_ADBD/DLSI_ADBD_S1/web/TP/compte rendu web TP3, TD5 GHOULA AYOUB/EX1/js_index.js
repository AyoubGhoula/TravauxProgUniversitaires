 function f(){
    var image = document.getElementById('image');
    var width = document.getElementById('width').value;
    var height = document.getElementById('height').value;
    var source = document.getElementById('source').value;
    if (document.getElementById('widthcheckbox').checked) {
        image.width = width;
    }

    if (document.getElementById('heightcheckbox').checked) {
        image.height = height;
    }
    image.src = source;
}