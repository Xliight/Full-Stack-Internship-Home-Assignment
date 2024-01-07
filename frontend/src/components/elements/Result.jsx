
import React, { useEffect } from 'react';


import { Button, Container, Flex, HStack, Stack, Text } from '@chakra-ui/react';
import Navbar from '../../navbar/Navbar';
import EmployeeList from './results/employeeResult/EmployeeList';
import JobList from './results/jobResult/JobList';
import { Link, useNavigate } from 'react-router-dom';


const Result = () => {

  const navigate = useNavigate();
  



  return (
    <>
    <Navbar/>

        <Stack maxW={"6xl"} p={12}  mx={"auto"} textAlign={'center'} bgColor={"#f7f9fa"}>


          <Container maxW="6xl" >
               <Link to={`/`}>
                  <Button
                    size="xl"
                    colorScheme="blue"
                    variant="solid"
                    width={'full'}
                    px={{ base: 6, md: 16 }}
                    py={{ base: 6, md: 7 }}
                  
                  >
                    Upload another one
                  </Button>
                  </Link>
                </Container>
          <EmployeeList/>
          <JobList/>
        
        </Stack>
        
    </>
  )
}

export default Result