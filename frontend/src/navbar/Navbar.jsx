import {
  Box,
  Button,
  Flex,
  HStack,
  IconButton,
  Image,
  useBreakpointValue,
  useColorModeValue,
  Container
} from '@chakra-ui/react';
import * as React from 'react';
import { Link, useLocation  } from 'react-router-dom';
import LogoWhite from './logo.svg';







const Navbar = () => {
  const isDesktop = useBreakpointValue({
    base: false,
    lg: true,
  });



   const location = useLocation();


  const [isScrolled, setIsScrolled] = React.useState(false);

  const handleScroll = () => {
    if (window.scrollY > 0) {
      setIsScrolled(true);
    } else {
      setIsScrolled(false);
    }
  };

  React.useEffect(() => {
    window.addEventListener('scroll', handleScroll);
    return () => window.removeEventListener('scroll', handleScroll);
  }, []);




  return (
    <Box
      as="nav"
      position="sticky"
      top="0"
      zIndex="100"
      bg={'white'}

      backdropFilter={isScrolled ? 'blur(4px)' : 'none'}
      transition="all 0.3s ease"
      boxShadow={isScrolled ? 'sm' : 'none'}
    >
      <Container as="section" maxW="7xl" >
      <Flex justify="space-between" align="center">
          
            <Link to="/" aria-label="Home">
              <Image src={LogoWhite} alt="Logo" height="24" width="auto" />
            </Link>

            <HStack spacing={4}>
              
                  <Link to={`/`}>
                  <Button color={"white"} bgColor={'#AFB5BF'} _hover={{ bg: '#959AA0' }}>
                    Home
                  </Button>
                  </Link>
                  
            </HStack>
           
        </Flex>
        
      </Container>
    </Box>
  );
};

export default Navbar;

