describe('Home', () => {
  it('display home page', () => {
    cy.visit('/');
    cy.get('#generator-link').should('exist');
  });
});