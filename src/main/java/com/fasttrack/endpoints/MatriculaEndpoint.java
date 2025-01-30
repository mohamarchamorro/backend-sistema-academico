package com.fasttrack.endpoints;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fasttrack.models.soap.EstudianteSOAP;
import com.fasttrack.models.soap.GetAllMatriculasRequest;
import com.fasttrack.models.soap.GetAllMatriculasResponse;
import com.fasttrack.models.soap.GetEstudiantesByMateriaRequest;
import com.fasttrack.models.soap.GetEstudiantesByMateriaResponse;
import com.fasttrack.models.soap.GetMateriasByEstudianteRequest;
import com.fasttrack.models.soap.GetMateriasByEstudianteResponse;
import com.fasttrack.models.soap.MateriaSOAP;
import com.fasttrack.models.soap.MatriculaSOAP;
import com.fasttrack.services.MatriculaService;

@Endpoint
@CrossOrigin(origins = "http://localhost:4200")
public class MatriculaEndpoint {
	
	private static final Logger logger = LoggerFactory.getLogger(MatriculaEndpoint.class);

	private static final String NAMESPACE_URI = "http://fasttrack.com/web-services-soap";

	private MatriculaService matriculaService;

	@Autowired
	public MatriculaEndpoint(MatriculaService matriculaService) {
		
		this.matriculaService = matriculaService;
	}


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllMatriculasRequest")
    @ResponsePayload
    public GetAllMatriculasResponse getAllMatriculas(@RequestPayload GetAllMatriculasRequest request) {
        
    	List<MatriculaSOAP> matriculas = matriculaService.findAll().stream().map(m -> 
        	new MatriculaSOAP(new EstudianteSOAP(m.getEstudiante().getId(), m.getEstudiante().getPrimer_nombre(), 
        			m.getEstudiante().getPrimer_apellido(), m.getEstudiante().getId_pais(),m.getEstudiante().getCorreo_electronico()), 
        			
        			new MateriaSOAP(m.getMateria().getId(), m.getMateria().getNombre()))).collect(Collectors.toList());
        
    	logger.info("getAllMatriculas()");
        GetAllMatriculasResponse response = new GetAllMatriculasResponse();
        response.setMatriculas(matriculas);
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMateriasByEstudianteRequest")
    @ResponsePayload
    public GetMateriasByEstudianteResponse getMateriasByEstudiante(@RequestPayload GetMateriasByEstudianteRequest request) {
        List<MatriculaSOAP> matriculas = matriculaService.materiasByEstudiante(request.getIdEstudiante()).stream().map(m -> 
    	new MatriculaSOAP(new EstudianteSOAP(m.getEstudiante().getId(), m.getEstudiante().getPrimer_nombre(), 
    			m.getEstudiante().getPrimer_apellido(), m.getEstudiante().getId_pais(),m.getEstudiante().getCorreo_electronico()), 
    			
    			new MateriaSOAP(m.getMateria().getId(), m.getMateria().getNombre()))).collect(Collectors.toList());
        
        logger.info("getMateriasByEstudiante()");
        GetMateriasByEstudianteResponse response = new GetMateriasByEstudianteResponse();
        response.setMatriculas(matriculas);
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEstudiantesByMateriaRequest")
    @ResponsePayload
    public GetEstudiantesByMateriaResponse getEstudiantesByMateria(@RequestPayload GetEstudiantesByMateriaRequest request) {
        List<MatriculaSOAP> matriculas = matriculaService.estudiantesByMateria(request.getNombreMateria()).stream().map(m -> 
    	new MatriculaSOAP(new EstudianteSOAP(m.getEstudiante().getId(), m.getEstudiante().getPrimer_nombre(), 
    			m.getEstudiante().getPrimer_apellido(), m.getEstudiante().getId_pais(),m.getEstudiante().getCorreo_electronico()), 
    			
    			new MateriaSOAP(m.getMateria().getId(), m.getMateria().getNombre()))).collect(Collectors.toList());
        
        logger.info("getEstudiantesByMateria()");
        GetEstudiantesByMateriaResponse response = new GetEstudiantesByMateriaResponse();
        response.setMatriculas(matriculas);
        return response;
    }
    
    
}
