export default function PlacementCard(props: {eventName: String, location: String, placed: number, avgLpa: number}) {
    return (
        <div className="flex flex-col rounded-2xl bg-[var(--secondary-color)] h-fit border border-1 border-gray-300 shadow-md">
            <img
                src={"./logos/company/amazon.png"}
                alt={`${props.eventName}`}
                className="w-full h-1/6 object-cover rounded-t-2xl"
            />
            <div className="p-4 space-y-6">
                <div className="flex justify-between items-center">
                    <div>
                        <p className="text-base font-bold ">{props.eventName}</p>
                        <p className="text-sm">{props.location}</p>
                    </div>
                    {/* <div className="bg-[var(--main-color)] rounded-full flex justify-center items-center relative  w-6 p-5 text-white">
                        <p className="absolute">
                            {props.date}
                        </p>
                    </div> */}
                </div>
                    <div className="flex justify-between items-center">
                        <div className="flex flex-col space-y-2">
                            <p className=" font-semibold">Placed</p>
                            <p className="font-medium text-gray-500">Avg.LPA</p>
                        </div>
                        <div className="flex flex-col space-y-2">
                            <p className=" font-semibold">{props.placed}</p>
                            <p className="font-medium">{props.avgLpa}</p>
                        </div>
                    </div>
            </div>
        </div>
    );
}
