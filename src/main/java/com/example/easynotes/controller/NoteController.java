package com.example.easynotes.controller;



import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.Student;
import com.example.easynotes.repository.NoteRepository;
import com.example.easynotes.repository.StudentRepository;

import org.apache.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

	private static final Logger logger = Logger.getLogger(NoteController.class);
	@Autowired
	Environment environment;
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    StudentRepository StudentRepository;
 // Get All Notes
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {

		model.addAttribute("greeting", "3-D Secure-2.0 ACS");

		for (final String profileName : environment.getActiveProfiles()) {
			logger.info("Currently active profile - " + profileName);
		}
		
		return "welcome";
	}
    
    
 // Create a new Note
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
    	logger.info("get all note data");
        return noteRepository.save(note);
    }

 // Get a Single Note
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
    	logger.info("get  note data for id : "+noteId);
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

 // Update a Note
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                                            @Valid @RequestBody Note noteDetails) {

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
    	logger.info("update note data");
        return updatedNote;
    }

 // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);
    	logger.info("delete note data");
        return ResponseEntity.ok().build();
    }
    
 // Get All Notes
    @GetMapping("/stu")
    public List<Student> getAllS() {
        return StudentRepository.findAll();
    }

 // Create a new Note
    @PostMapping("/stu")
    public Student createStu(@Valid @RequestBody Student note) {
        return StudentRepository.save(note);
    }

 // Get a Single Note
    @GetMapping("/stu/{id}")
    public Student getStueById(@PathVariable(value = "id") Long noteId) {
        return StudentRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

 // Update a Note
    @PutMapping("/stu/{id}")
    public Student updateStu(@PathVariable(value = "id") Long noteId,
                                            @Valid @RequestBody Note noteDetails) {

    	Student student = StudentRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        student.setTitle(noteDetails.getTitle());
        student.setContent(noteDetails.getContent());

        Student updatedStudent = StudentRepository.save(student);
        return updatedStudent;
    }

 // Delete a Note
    @DeleteMapping("/stu/{id}")
    public ResponseEntity<?> deleteStu(@PathVariable(value = "id") Long noteId) {
        Student student = StudentRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        StudentRepository.delete(student);

        return ResponseEntity.ok().build();
    }
    
    
    
}