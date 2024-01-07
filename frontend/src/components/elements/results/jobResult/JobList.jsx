import React, { useState } from 'react';
import {
  Box,
  Button,
  ButtonGroup,
  Container,
  HStack,
  Icon,
  Input,
  InputGroup,
  InputLeftElement,
  Stack,
  Text,
  useBreakpointValue,
  useColorModeValue,
} from '@chakra-ui/react';
import { FiSearch } from 'react-icons/fi';
import { JobTable } from './JobTable';
import { averageSalary } from './data';

const JobList = () => {
  const salaryArray = Object.entries(averageSalary).map(([jobTitle, averageSalary]) => ({
    jobTitle,
    averageSalary,
  }));

  return (
    <Container maxW={'7xl'} py={{ base: '6', md: '6' }} alignItems={"center"} justifyContent={"center"}>
      <Box
        // bg="bg-surface"
        bg="white"
        boxShadow={useColorModeValue('md', 'md-dark')}
        borderRadius={useBreakpointValue({ base: 'none', md: 'lg' })}
      >
        <Stack spacing="5">
          <Box overflowY="auto">
            <JobTable averageSalary={salaryArray} />
          </Box>
        </Stack>
      </Box>
    </Container>
  );
};

export default JobList;