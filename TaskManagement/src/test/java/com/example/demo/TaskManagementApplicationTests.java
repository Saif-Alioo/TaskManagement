package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.model.Profile;
import com.example.demo.repo.ProfileRepo;
import com.example.demo.service.ProfileService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class TaskManagementApplicationTests {

//	@Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ProfileService profileService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void givenProfileObject_whenCreateProfile_thenReturnSavedProfile() throws Exception{
//
//        // given - precondition or setup
//        Profile profile = Profile.builder()
//                .proid(1)
//                .name("Fadatare")
//                .image(null)
//                .build();
//        given(profileService.uploadProfile(any(Profile.class)))
//                .willAnswer((invocation)-> invocation.getArgument(0));
//
//        // when - action or behaviour that we are going test
//        ResultActions response = mockMvc.perform(post("/api/employees")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(objectMapper.writeValueAsString(profile)));
//
//         //then - verify the result or output using assert statements
//        response.andDo(print()).
//                andExpect(status().isCreated())
//                .andExpect(jsonPath("$.Id",
//                        is(profile.getProid())))
//                .andExpect(jsonPath("$.Name",
//                        is(profile.getName())))
//                .andExpect(jsonPath("$.Image",
//                        is(profile.getImage())));
//    }

	@Autowired
	private ProfileService profileService;
    @MockBean
    private ProfileRepo profileRepo;
    @Test
    //Test getProfile Method.
    public void Test_GetTotal_numberof_Profile_inMockedRepo() {
    	when(profileRepo.findAll()).thenReturn(Stream
    			.of(new Profile(1,"Jhon",null),new Profile(2,"Rahul",null)).collect(Collectors.toList()));
    	assertEquals(2,profileService.getProfiles().size());
    	
    }
//    @Test
//    public void getProfile_By_using_ProfileId() {
//    	Profile profile=new Profile(1,"Saif",null);
//    	when(profileRepo.save(profile)).thenReturn(profile);
//    	assertEquals(profile, profileService.uploadProfile(1, "Saif", null));
//    }
    
    @Test
    public void test_Delete_Profile(){
    	Profile profile=new Profile(1,"Jhon",null);
    	profileRepo.delete(profile);
//    	verify(profileRepo,times(1)).delete(profile);
    }
    
    
}
