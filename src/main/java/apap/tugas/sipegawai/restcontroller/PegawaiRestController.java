package apap.tugas.sipegawai.restcontroller;

import apap.tugas.sipegawai.model.PegawaiModel;
import apap.tugas.sipegawai.rest.BaseResponse;
import apap.tugas.sipegawai.rest.PegawaiDto;
import apap.tugas.sipegawai.service.PegawaiRestService;
import apap.tugas.sipegawai.service.RoleRestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class PegawaiRestController {
    @Autowired
    private PegawaiRestService pegawaiRestService;

    @Autowired
    private RoleRestService roleRestService;

    @Autowired
    private ModelMapper modelMapper;

    private PegawaiModel convertToEntity(PegawaiDto pegawaiDto) throws ParseException {
        PegawaiModel pegawaiModel = modelMapper.map(pegawaiDto, PegawaiModel.class);
        return pegawaiModel;
    }

    @PostMapping(value = "/pegawai")
    private BaseResponse<PegawaiModel> createPegawai(@Valid @RequestBody PegawaiDto pegawai, BindingResult bindingResult){
        BaseResponse<PegawaiModel> response;
        response = new BaseResponse<>();
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }
        else {
            PegawaiModel pegawaiModel = convertToEntity(pegawai);
            pegawaiModel = pegawaiRestService.createPegawai(pegawaiModel);
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(pegawaiModel);
            return response;
        }
    }

    @GetMapping(value = "/pegawai/{username}")
    private BaseResponse<PegawaiModel> retrievePegawai(@PathVariable("username") String username){
        BaseResponse<PegawaiModel> response;
        response = new BaseResponse<>();
        try{
            PegawaiModel pegawai = pegawaiRestService.getPegawaiByUsername(username);
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(pegawai);
            return response;
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Username Pegawai "+String.valueOf(username)+" Not Found"
            );
        }
    }


    @GetMapping(value = "/pegawai")
    private BaseResponse<List<PegawaiModel>> retrieveListPegawai(){
        BaseResponse<List<PegawaiModel>> response = new BaseResponse<>();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(pegawaiRestService.getAllPegawai());
        return response;
    }

}