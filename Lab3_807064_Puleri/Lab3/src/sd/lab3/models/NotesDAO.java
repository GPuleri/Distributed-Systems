package sd.lab3.models;

import java.util.ArrayList;
import java.util.List;
import sd.lab3.models.Note;

public class NotesDAO {
 private static NotesDAO instance = null;
 private int maxID = 0;
 private List<Note> notes = new ArrayList<>();

 public static NotesDAO getInstance() {
 if (instance == null) {
 instance = new NotesDAO();
 }
 return instance;
 }
 
 private NotesDAO() {}

 public int saveNote(Note newNote) {
 maxID++;
 newNote.setId(maxID);
 this.notes.add(newNote);
 return maxID;
 }

 public Note getNote(int id) {
 
	 for(Note note : notes) {
		 if(note.getId() == id) {
			 return note;
			 }
		 }
	 return null;
	 }
 
 public List<Note> getNotes(){
	 return notes;
 }
}