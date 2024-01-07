import React, { useState } from 'react';
import { Button, Center, Container, Flex, FormControl, HStack, Icon, Square, Stack, Text, VStack, useColorModeValue, Box } from '@chakra-ui/react';
import Navbar from '../navbar/Navbar';
import { useNavigate } from 'react-router-dom';
import { FiUploadCloud } from 'react-icons/fi';
import { BsFileEarmarkExcel } from "react-icons/bs";


const Home = () => {
  const navigate = useNavigate();
  const [process, setProcess] = useState(false);
  const [fileInfo, setFileInfo] = useState(null); 

  const handleFileUpload = (event) => {
    const selectedFile = event.target.files[0];
    const fileName = selectedFile.name;
    const fileSize = selectedFile.size; 

    const sizeInKB = fileSize / 1024;
    const sizeInMB = sizeInKB / 1024;
    const formattedSize = sizeInMB > 1 ? `${sizeInMB.toFixed(2)} MB` : `${sizeInKB.toFixed(2)} KB`;

    setFileInfo({
      name: fileName,
      size: formattedSize,
    });
    setProcess(true);
  };


  const handleButtonClick = () => {
    navigate('/result');
  };

  return (
    <>
      <Navbar />
      <Stack maxW={"6xl"} p={12} height={"70vh"} mx={"auto"} textAlign={'center'} bgColor={"#f7f9fa"}>
        <Text mt={5} fontSize="3xl" fontWeight="meduim" className="PopB" textAlign={"center"}>
          Upload your csv file 
        </Text>

        <HStack m={0} p={0} justifyContent="center" bgColor={""}>
          <Stack justifyContent="center" alignItems="center">
            <Flex justifyContent="center" alignItems="center" gap={10}>
              <Container maxW="" mt={24}>
                <FormControl id="file">
                  <Center
                    borderWidth="1px"
                    borderRadius="lg"
                    px="6"
                    py="4"
                    bg={useColorModeValue('white', 'gray.800')}
                    w="4xl"
                  >
                    <VStack spacing="3">
                      <Square size="10" bg="bg-subtle" borderRadius="lg">
                        <Icon as={FiUploadCloud} boxSize="5" color="muted" />
                      </Square>
                      <VStack spacing="1">
                        <HStack spacing="1" whiteSpace="nowrap">
                          <input
                            type="file"
                            id="fileInput"
                            style={{ display: 'none' }}
                            onChange={handleFileUpload}
                          />
                          <label htmlFor="fileInput">
                            <Button variant="link" colorScheme="blue" size="sm" as="span">
                              Click to upload
                            </Button>
                          </label>
                          <Text fontSize="sm" color="muted">
                            or drag and drop
                          </Text>
                        </HStack>
                        <Text fontSize="xs" color="muted">
                          CSV file up to 2MB
                        </Text>
                      </VStack>
                    </VStack>
                  </Center>
                </FormControl>
              </Container>

              {process && (
                <Container maxW="" mt={24}>
                  <Button
                    size="xl"
                    colorScheme="blue"
                    variant="solid"
                    px={{ base: 6, md: 16 }}
                    py={{ base: 6, md: 12 }}
                    onClick={() => handleButtonClick()}
                  >
                    Process
                  </Button>
                </Container>
              )}

            </Flex>

            {process && (
                    <HStack w={"6xl"} mt={5} p={2} justify="space-between" bgColor="gray.300" borderWidth="1px" borderRadius="lg">
                      <HStack>
                        <Square size="12" bg="bg-subtle" borderRadius="lg">
                          <Icon as={BsFileEarmarkExcel} boxSize="10" color="muted" />
                        </Square>
                        <Box textAlign="left" fontSize="sm">
                         
                          <Text className="Pop" color="muted">
                            {fileInfo.name}
                          </Text>

                          <Text className="PopM" color="empahsized" fontWeight="medium">
                            Size : {fileInfo.size}
                          </Text>
                        </Box>
                      </HStack>
                     
                    </HStack>
                  )}
          </Stack>
        </HStack>
      </Stack>
    </>
  );
};

export default Home;
