# Fund Me project with Solidity & JS

This project is part of the FCC Blockchain course. It has two contracts which depict the usecase of a FundMe campaign, there are deployment, testing and other scripts involved in the project.

It is created with the help of hardhat:

```shell
yarn hardhat help
yarn hardhat node
yarn hardhat run scripts/deploy.js
yarn hardhat run scripts/withdraw.js --network localhost
yarn hardhat run scripts/fund.js --network localhost  
```

```
yarn install
yarn hardhat compile
yarn hardhat deploy --network sepolia
yarn hardhat test
```