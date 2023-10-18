require("@nomicfoundation/hardhat-toolbox")
require("dotenv").config()
require("./tasks/block-number")
require("hardhat-gas-reporter")
require("solidity-coverage")

/** @type import('hardhat/config').HardhatUserConfig */

const SEPOLIA_RPC_URL = process.env.SEPOLIA_RPC_URL || "undefined"
const PRIVATE_KEY = process.env.PRIVATE_KEY || "undefined"
const ETHERSCAN_API_KEY = process.env.ETHERSCAN_API_KEY || "undefined"
const COIN_KEY = process.env.COIN_API_KEY || "undefined"

module.exports = {
    defaultNetwork: "hardhat",
    networks: {
        sepolia: {
            url: SEPOLIA_RPC_URL,
            accounts: [PRIVATE_KEY],
            chainId: 11155111,
        },
        localhost: {
            url: "http://127.0.0.1:8545/",
            //accounts: From hardhat,
            chainId: 31337,
        },
    },
    solidity: "0.8.8",
    etherscan: {
        apiKey: ETHERSCAN_API_KEY,
    },
    gasReporter: {
        enabled: false,
        //outputFile
        noColours: true,
        currency: "USD",
        coinmarketcap: COIN_KEY,
        token: "MATIC",
    },
}
