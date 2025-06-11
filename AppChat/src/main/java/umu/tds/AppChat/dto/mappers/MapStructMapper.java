package umu.tds.AppChat.dto.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import umu.tds.AppChat.dto.*;
import umu.tds.dominio.*;


@Component
@Mapper(componentModel = "spring")
public interface MapStructMapper {

	public UsuarioDTO getDTO(Usuario u);
	public Usuario getUsuario(UsuarioDTO uDTO);
	
	public MensajeDTO getDTO(Mensaje m);
	public Mensaje getMensaje(MensajeDTO mDTO);
	
	public ContactoIndividualDTO getDTO(ContactoIndividual c);
	public ContactoIndividual getContacto(ContactoIndividualDTO cDTO);
	
	public GrupoDTO getDTO(Grupo g);
	public Grupo getGrupo(GrupoDTO gDTO);
	
}
