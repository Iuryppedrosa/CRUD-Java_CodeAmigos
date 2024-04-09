package com.example.AmigosCodeProject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository   studentRepository;

    public List<Student> getStudents( ){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if( studentOptional.isPresent()){
            throw new IllegalArgumentException("Student already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if(!studentExists){
            throw new IllegalArgumentException("Student does not exist:" + studentId);
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public Student updateStudent(Long id, Student newStudentData) {
        // Verificar se o estudante existe
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estudante não encontrado com o ID fornecido: " + id));

        // Atualizar os dados do estudante existente
        existingStudent.setName(newStudentData.getName());
        existingStudent.setBod(newStudentData.getBod());
        existingStudent.setEmail(newStudentData.getEmail());

        // Salvar e retornar o estudante atualizado
        return studentRepository.save(existingStudent);
    }
}
