package com.edu.miu.cs.cs425.studenmgmt.model.ServiceLayer;

import com.edu.miu.cs.cs425.studenmgmt.model.Classroom;
import com.edu.miu.cs.cs425.studenmgmt.model.Exception.ClassroomNotFoundException;
import com.edu.miu.cs.cs425.studenmgmt.model.Repositories.ClassroomRepository;
import com.edu.miu.cs.cs425.studenmgmt.model.ServiceImp.ClassroomImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements ClassroomImp {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Classroom saveClassroom(Classroom classroom) {
        try {
            return classroomRepository.save(classroom);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error saving classroom: " + e.getMessage());
        }
    }

    @Override
    public Classroom getClassroomById(Long id) {
        return classroomRepository.findById(id)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found with ID: " + id));
    }

    @Override
    public void deleteClassroom(Long id) {
        try {
            classroomRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ClassroomNotFoundException("Classroom not found with ID: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error deleting classroom: " + e.getMessage());
        }
    }

    @Override
    public List<Classroom> getAllClassroom() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom updateClassroom(Classroom classroom, Long id) {
        if (!classroomRepository.existsById(id)) {
            throw new ClassroomNotFoundException("Cannot update. Classroom not found with ID: " + id);
        }
        classroom.setClassroomId(id);
        try {
            return classroomRepository.save(classroom);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error updating classroom: " + e.getMessage());
        }
    }
}