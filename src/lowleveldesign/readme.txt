Snake and Ladder
------------------

Dice  - rolllDice
Jumper
Player
Gameboard  - dice,  Queue<Player>, List<Jumper>. Map<String, Intger>  playerPoistion, int boardSize.
    startGame() (while queuesize > 1)


Parking Lot
------------------

ParkingLot - Address, Name,  List<ParkingFloor>, List<Entrance>, List<Exists>
            * isParkingAvailable(Vehicle) ,

ParkingFloor -   floorId, isFull, List<ParkingSpace>, ParkingDisplayBoard

ParkingSpace -  spotId, ParkingSpaceType, isFree, (costPerHr), Vehicle

ParkingDisplayBoard - Map<ParkingSpaceType, Integer>
                    * inCFreeSpotsAvaillable(ParkingSpaceType, int)
                    * deCFreeSpotsAvaillable(ParkingSpaceType, int)

Vehicle: licence, VehicleType, ParkingSpaceType,

ParkingTicket: ticketId, levelId, spaceId, entry/exitTime,  totalCost, ParkingSpaceType, ParkingTicketStatus
               *updateTotalCost
               *updateVehicleExitTime

Gate
    - Entrance, Exit  : id, ParkingAttendent
        *    ParkingTicket getParkingTicket(Vehicle)
        *    ParkingTicket payParkingTicket(ParkingTicket, PaymentType)

Address

enum VehicleType, (ParkingSpaceType), PaymentType, ParkingTicketStatus

(ParkingSpaceType) - costPerHr

Account -
    Admin
        *addFloor, addSpace, addDisplayBoard
    ParkingAttendent :  PaymentService ??
            proccessEntry(Vehicle)
            processPayment(PaymentInfo, ParkingTicket)

------------------------------------------------------------------------------------------
Elevator

ElevatorCar : ButtonPanel, Door, startFloor, endFloor, currentFloor.
                * isMoving, isMovingUp, moveToFloor


interface ButtonPanel: bool isMovingUp, Map<int, boolean> floorStatus
            * sendInstructionToDispatcher(curr, dest, isMovingUp)

Door  : isOpen
        * closeDoor()
        * openDoor()
Floor : int currFloor, ButtonPanel
        * callElevetor()

DispatcherUnit

EleSystem :  List<Elevator> elevators, List<Floor>
            * startEle, * stopEle
