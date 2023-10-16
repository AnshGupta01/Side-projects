const { ethers } = require("hardhat")
const { expect, assert } = require("chai")
const repl = require("repl")

describe("SimpleStorage", async function () {
    let simpleStorageFactory, simpleStorage
    beforeEach(async function () {
        simpleStorageFactory = await ethers.getContractFactory("SimpleStorage")
        simpleStorage = await simpleStorageFactory.deploy()
    })

    it("should start with a favorite number of 0", async function () {
        const currentValue = await simpleStorage.retrieve()
        const expectedValue = 0
        //assert, expect
        assert.equal(currentValue.toString(), expectedValue)
        //expect(currentValue.toString()).to.equal(expectedValue)
    })

    it("should update when we call store", async function () {
        const expectedValue = "7"
        const transResponse = await simpleStorage.store(expectedValue)
        await transResponse.wait(1)

        const currentValue = await simpleStorage.retrieve()
        assert.equal(currentValue.toString(), expectedValue)
    })

    it("should add person with name & favorite number", async function () {
        const person_name = "ansh"
        const person_number = 10
        const response = await simpleStorage.addPerson(
            person_name,
            person_number,
        )
        await response.wait(1)
        const { favoriteNumber, name } = await simpleStorage.people(0)
        assert.equal(favoriteNumber, person_number)
        assert.equal(name, person_name)
    })
})
