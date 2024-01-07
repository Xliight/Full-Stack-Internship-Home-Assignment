// MemberTable.jsx

import React from 'react';
import {
  Table,
  Thead,
  Tbody,
  Tr,
  Th,
  Td,
  HStack,
  Text,
  IconButton,
  Box,
  Badge
} from '@chakra-ui/react';
import { FiTrash2 } from 'react-icons/fi';

export const MemberTable = ({ members, startIndex, endIndex }) => (
  <Table>
    <Thead>
      <Tr bgColor={'gray.200'}>
        <Th>id</Th>
        <Th>Employee Name</Th>
        <Th>Job Title</Th>
        <Th>Salary</Th>
        <Th></Th>
      </Tr>
    </Thead>
    <Tbody>
      {members.slice(startIndex, endIndex).map((member) => (
        <Tr key={member.id}>
          <Td>
              <Badge size="sm" colorScheme={'green'}>
                  {member.id}
              </Badge>
          </Td>
          <Td>
            <HStack spacing="3">
              <Box>
                <Text fontWeight="medium">{member.employeeName}</Text>
              </Box>
            </HStack>
          </Td>
          <Td>
            <Text color="muted">{member.jobTitle}</Text>
          </Td>
          <Td>
            <Text color="muted">{member.salary}</Text>
          </Td>
         
          <Td>
            <HStack spacing="1">
            <IconButton icon={<FiTrash2 fontSize="1.25rem" />} colorScheme='red' aria-label="Delete member" />
             
              
            </HStack>
          </Td>
        
        </Tr>
      ))}
    </Tbody>
  </Table>
);


