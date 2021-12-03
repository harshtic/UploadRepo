

const showNotes = document.getElementById('showNotes');
const deleteNotes = document.getElementsByClassName('deleteNotes');





const deleteNote = async ()=>{
	let note_id = document.getElementById('note_id');
	console.log(note_id.innerHTML);
	const response = await fetch(`deleteNote.do?noteId=${note_id.innerHTML}`);
	window.location.reload();
	const data = response.text();
	
	return data;
};

deleteNotes.forEach((deleteNote)=>{
	deleteNote.addEventListener('click',()=>{
	deleteNote().then((data)=>{
		console.log("success1")
		
	});
});
});



const ajaxRequest = async ()=>{
	const response = await fetch('showNotes.do');
	const data = response.json();
	return data;
};


document.addEventListener("DOMContentLoaded", ()=>{
	
	ajaxRequest().then((data1)=>{
		console.log(data1);
		for(var d in data1){
			console.log(data1[d].title);
		}
		
	}).catch((error)=>{});
});

