import React from "react";
import FindPassword from "../../components/auth/FindPassword";
import styled from "styled-components";
import Header from "../Header";
import Footer from "../Footer";

const PageContainer = styled.div`
  display: flex;
  flex-direction: column;
  min-height: 500vh;
`;

// const ContentContainer = styled.div`
//   flex: 1;
// `;

const FindPasswordContainer = () => {
  return (
    <PageContainer>
      <Header />
      <FindPassword />
      <Footer />
    </PageContainer>
  );
};

export default FindPasswordContainer;
