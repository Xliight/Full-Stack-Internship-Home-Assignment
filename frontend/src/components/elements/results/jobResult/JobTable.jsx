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

export const JobTable = ({ averageSalary }) => (
  <Table>
    <Thead>
      <Tr bgColor={'gray.200'}>
        <Th>Job Title</Th>
        <Th>Average Salary</Th>
      </Tr>
    </Thead>
    <Tbody>
      {averageSalary.map((job, index) => (
        <Tr key={index}>
          <Td>
            <HStack spacing="3">
              <Box>
                <Text fontWeight="medium">{job.jobTitle}</Text>
              </Box>
            </HStack>
          </Td>

          <Td>
            <HStack spacing="3">
              <Box>
                <Text fontWeight="medium">{job.averageSalary}</Text>
              </Box>
            </HStack>
          </Td>
        </Tr>
      ))}
    </Tbody>
  </Table>
);