export default function EventCard(props: {eventName: String, location: String, date : number, description: String}) {
    return (
        <div className="flex flex-col rounded-2xl bg-[var(--secondary-color)] h-fit">
            <img
                src={"https://github.com/psidh.png"}
                alt="Neeraj Chopra"
                className="w-full h-1/6 object-cover rounded-t-lg"
            />
            <div className="p-4 space-y-3">
                <div className="flex justify-between items-center">
                    <div>
                        <p className="text-base font-bold ">{props.eventName}</p>
                        <p className="text-sm">{props.location}</p>
                    </div>
                    <div className="bg-[var(--main-color)] rounded-full flex justify-center items-center relative  w-6 p-5 text-white">
                        <p className="absolute">
                            {props.date}
                        </p>
                    </div>
                </div>
                <p className="text-xs">
                    {props.description}
                </p>
            </div>
        </div>
    );
}
