package ba.propertydamgerecognition.service;

import ba.propertydamgerecognition.entity.Incident;
import ba.propertydamgerecognition.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public List<Incident> getAll() {
        return incidentRepository.findAll();
    }
}
